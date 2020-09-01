package org.zhx.executor;

import java.util.concurrent.*;

/**
 * @ProjectName: util-java
 * @Package: org.zhx.executor
 * @ClassName: FutureCheck
 * @Author: zhanghx
 * @Description: ${description}
 * @Date: 2020/9/1 17:05
 * @Version: 1.0
 */
public class FutureCheck implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        String result = "param";
        Future<String> submit = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>runnable");
            }
        }, result);
        FutureCheck check = new FutureCheck();
        Future<String> submit2 = executor.submit(check);
        final String s = submit.get();
        final String s2 = submit2.get();
        System.out.println(Thread.currentThread().getName() + ":" + s + ":" + s2);
        executor.shutdown();
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>call");
        return "我就返回自己了";
    }
}
