package org.generic.wild;

import org.generic.App;

import java.util.ArrayList;
import java.util.List;

//https://segmentfault.com/a/1190000005179147#articleHeader0
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error

    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    {
        for (int i=0; i<src.size(); i++)
            dest.set(i,src.get(i));
    }


    public static void main(String[] args) {
        List<? super Apple> list = new ArrayList<>();
        writeTo(list);
        for(Object apple : list){
            System.out.println(apple.getClass().getName());
        }
    }
}
