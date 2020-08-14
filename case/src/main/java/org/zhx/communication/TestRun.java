package org.zhx.communication;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;

public class TestRun {

    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedOutputStream out = new PipedOutputStream();
            PipedInputStream in = new PipedInputStream();

            //pip的Stream 可以产生通信连接的
            //in.connect(out);
            out.connect(in);

            //开启写线程
            ThreadWrite threadWrite = new ThreadWrite(writeData, out);
            threadWrite.start();

            Thread.sleep(4000);


            //开启读线程
            ThreadRead threadRead = new ThreadRead(readData, in);
            threadRead.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
