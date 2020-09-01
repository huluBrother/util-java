package org.zhx.communication;

import ch.qos.logback.core.net.server.ConcurrentServerRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
    public static ConnectionPool pool = new ConnectionPool(10);

    //保证所有的ConnectionRunner 能够同时开始
    public static CountDownLatch start =new CountDownLatch(1);

    //保证main线程将会等待所有Connection Runner结束后才能继续执行
    public static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCound = 50;//线程数量，可以修改进行观察
        end = new CountDownLatch(threadCound);

        int count = 20;
        AtomicInteger got = new AtomicInteger();//统计拿到的记录
        AtomicInteger notGot = new AtomicInteger();//统计没有拿到的

        for(int i=0;i<threadCound;i++){
            Thread thread = new Thread(new ConnetionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }

        start.countDown();//通知所有阻塞线程，开始
        end.await();//阻塞等待


        System.out.println("total invoke:" + (threadCound * count));
        System.out.println("got connection:" + got);
        System.out.println("not got connection:" + notGot);
    }


    public static class ConnetionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnetionRunner(int count ,AtomicInteger got,AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        @Override
        public void run() {
            try {
                start.await();//阻塞，等待开始信号
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while(count > 0){

                try {
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }

                    }else{
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();//准备就绪
        }
    }
}
