package org.generic;

/**
 * 方法使用泛型
 */
public class GenericMethod {

    public <K,V> void f(K k, V v){
        System.out.println(k.getClass().getSimpleName());//类名
        System.out.println(k.getClass().getName());//包.类名
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f(new Integer(2019),new String("generic"));
    }
}
