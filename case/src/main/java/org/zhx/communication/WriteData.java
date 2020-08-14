package org.zhx.communication;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {


    public void writeMethod(PipedOutputStream out){
        try{
            for(int i=0;i<500;i++){
                StringBuffer buffer = new StringBuffer("当前次数");
                buffer.append((i+1));
                out.write(buffer.toString().getBytes());
                System.out.println("write ===> " + buffer.toString());
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
