package org.zhx.communication;

import java.io.IOException;
import java.io.PipedInputStream;
import java.nio.file.Path;
import java.util.Arrays;

public class ReadData {


    public void readMethod(PipedInputStream in){
        try {
            byte byteArray[] = new byte[20480];
            Arrays.fill(byteArray,(byte) 0);
            int readLength = in.read(byteArray);
            StringBuffer buffer = new StringBuffer("read <===");
            int offset = 0;

            while(readLength != -1){
                buffer.append(new String(byteArray,0,readLength)).append("\n");
                readLength = in.read(byteArray);
            }
            //buffer.append(new String(byteArray));
            System.out.println(buffer.toString());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
