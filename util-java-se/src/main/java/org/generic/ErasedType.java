package org.generic;

import java.util.ArrayList;

/**
 * 类型擦除导致的问题
 */
public class ErasedType {

    public static void main(String[] args) {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2);
    }
}
