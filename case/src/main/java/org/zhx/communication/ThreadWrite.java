package org.zhx.communication;

import java.io.PipedOutputStream;

public class ThreadWrite extends  Thread{

    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write , PipedOutputStream out){
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        System.out.println("写线程启动成功");
        this.write.writeMethod(out);
    }
}
