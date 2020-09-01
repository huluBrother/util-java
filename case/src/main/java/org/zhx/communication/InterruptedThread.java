package org.zhx.communication;

import java.util.concurrent.TimeUnit;

public class InterruptedThread {

    public static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(10);//睡眠的时候被中止会抛异常，会被清除中止标记
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while(true){
                int k = 0;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(),"busyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
