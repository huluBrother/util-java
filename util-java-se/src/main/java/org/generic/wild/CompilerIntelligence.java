package org.generic.wild;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompilerIntelligence {


    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Fruit fruit = new Fruit();
        Jonathan jon = new Jonathan();
        Orange orange = new Orange();


        List<? extends Fruit> flist = Arrays.asList(apple1,fruit,jon,orange);
        Apple a = (Apple) flist.get(0); // No warning
        System.out.println(a == apple1);
        System.out.println(a.equals(apple1));

        boolean hasAppleObject = flist.contains(new Apple());// Argument is ‘Object’
        System.out.println("hasApple : " + hasAppleObject);
        hasAppleObject = flist.contains(a);// Argument is ‘Object’
        System.out.println("hasApple : " + hasAppleObject);
        int  index = flist.indexOf(new Apple());// Argument is ‘Object’
        System.out.println("index : " + index);
        index = flist.indexOf(fruit);// Argument is ‘Object’
        System.out.println("index : " + index);

        System.out.println(flist.size());
        System.out.println( flist.get(0).getClass().getName());
        System.out.println(flist.get(1).getClass().getName());
        System.out.println(flist.get(2).getClass().getName());
        System.out.println(flist.get(3).getClass().getName());
        //flist.add(new Apple());   //无法编译
        Collections.shuffle(flist);
        System.out.println(flist.size());
        System.out.println( flist.get(0).getClass().getName());
        System.out.println(flist.get(1).getClass().getName());
        System.out.println(flist.get(2).getClass().getName());
        System.out.println(flist.get(3).getClass().getName());
    }
}
