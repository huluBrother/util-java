package org.zhx.threadpool;


import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //线程池默认限制数
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //线程池最小限制数量
    private static final int MIN_WORKER_NUMBERS = 1;

    //这是一个工作列表，将会向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<>();

    //工作者列表，我很好奇这个类
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    //工作者线程数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;

    //线程编号的生成
    private AtomicLong threadNum = new AtomicLong();



    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            //添加一个工作，然后进行通知
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker : workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            //限制新增的worker数量不能超过最大值
            if(num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num >= this.workerNum){
                num = this.workerNum;
            }
            //按照给定的数量停止Worker
            int count = 0;
            while(count < num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num){
        Worker worker = new Worker();
        workers.add(worker);

        Thread thread = new Thread(worker,"ThreadPool-Worker-" + threadNum.incrementAndGet());
        thread.start();
    }

    public class Worker implements Runnable{

        //是否在工作
        private volatile  boolean running = true;

        @Override
        public void run() {
            while(running){
                Job job = null;
                synchronized (jobs){
                    while(jobs.isEmpty()){
                        try {
                            job.wait();//wait 是否会释放 synchronized 锁  答案是会释放
                        } catch (InterruptedException e) {
                            //感知到外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null){
                    job.run();
                }
            }
        }

        public void shutdown(){
            this.running = false;
        }
    }
}
