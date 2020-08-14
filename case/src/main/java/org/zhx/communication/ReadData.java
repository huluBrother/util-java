package org.zhx.communication;

import java.io.IOException;
import java.io.PipedInputStream;
import java.nio.file.Path;

public class ReadData {


    public void readMethod(PipedInputStream in){
        try {
            byte byteArray[] = new byte[20];
            int readLength = in.read(byteArray);
            StringBuffer buffer = new StringBuffer("read <===");
            while(readLength != -1){
                buffer.append(new String(byteArray,0,readLength));
                readLength = in.read(byteArray);
                System.out.println(buffer.toString());
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
