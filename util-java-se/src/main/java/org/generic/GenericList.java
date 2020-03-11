package org.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合形式的泛型
 * @param <B>
 */
public class GenericList<B extends List>{
    private B mylist;
    private B [] myArray;

    public B getMylist() {
        return mylist;
    }

    public void setMylist(B mylist) {
        this.mylist = mylist;
    }

    public B[] getMyArray() {
        return myArray;
    }

    public void setMyArray(B[] myArray) {
        this.myArray = myArray;
    }

    public <K,V> String genericMethod(int n, K key ,V value){
        StringBuffer buffer = new StringBuffer();
        buffer.append("key:").append(key.toString());
        buffer.append(" && ");
        buffer.append("value:").append(value.toString());
        return buffer.toString();
    }

    public static void main(String[] args) {
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
