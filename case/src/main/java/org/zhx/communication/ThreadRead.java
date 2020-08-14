package org.zhx.communication;

import java.io.PipedInputStream;

public class ThreadRead extends  Thread{
    private ReadData read;
    private PipedInputStream in;

    public ThreadRead(ReadData read,PipedInputStream in){
        super();
        this.read = read;
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("读线程启动成功");
        this.read.readMethod(in);
    }
}
