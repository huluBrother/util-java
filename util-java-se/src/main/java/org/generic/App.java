package org.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
        GenericList<List<Integer>> mylist = new GenericList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        mylist.setMylist(list);
        List<Integer> getList = mylist.getMylist();
        System.out.println(getList);

        List<Integer> listArray[] = new List[2];
        listArray[0] = new ArrayList<>();
        listArray[1] = new ArrayList<>();
        for(int i=0;i<10;i++){
            listArray[0].add(i*10);
            listArray[1].add(i*20);
        }
        mylist.setMyArray(listArray);
        List<Integer>[] getListArray = mylist.getMyArray();
        System.out.println(getListArray.length);
        System.out.println(listArray[0]);
        System.out.println(listArray[1]);
        String method = mylist.genericMethod(0, list, listArray);
        System.out.println(method);
        method = mylist.genericMethod(0, 10, " years old");
        System.out.println(method);
    }

}
