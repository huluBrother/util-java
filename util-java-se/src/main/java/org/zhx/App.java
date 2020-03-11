package org.zhx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.generic.GenericList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void test(){
        System.out.println("java SE 功能模块测试");

        try {
            File file = new File("C:\\Users\\zhanghx\\Desktop\\datalog_2019-06-23");
            List<String> allLine = Files.readAllLines(file.toPath());
            for(String str : allLine){
                //System.out.println(str);
                JSONObject obj = JSON.parseObject(str);
                for(Map.Entry<String, Object> item : obj.entrySet()){
                    if(item.getValue() instanceof  JSONObject){
                        JSONObject inObject = (JSONObject) item.getValue();
                        for(Map.Entry<String, Object> inItem : inObject.entrySet()){
                            logger.info("-->" + item.getKey()+"="+item.getValue().toString());
                        }
                    }else{
                        logger.info(item.getKey()+"="+item.getValue());
                    }

                }
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main( String[] args ){
        try{
            for(int i=0;i<14;i++){
                System.out.println((1 << i)) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
