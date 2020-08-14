package org.zhx.communication;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {


    public void writeMethod(PipedOutputStream out){
        try{
            for(int i=0;i<200;i++){
                StringBuffer buffer = new StringBuffer("中文----->");
                buffer.append((i+1));
                buffer.append("\n");
                out.write(buffer.toString().getBytes());
                out.flush();
                //System.out.println("write ===> " + buffer.toString());
            }
           //
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
