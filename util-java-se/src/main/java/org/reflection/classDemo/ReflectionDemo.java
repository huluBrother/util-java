package org.reflection.classDemo;

public class ReflectionDemo {

    public Class<?> testClass(){
        //return new ReflectionDemo();
        return this.getClass();
    }

    public <T> Class<T> getGeneric(T a){
        //return a;//Error
        //return a.getClass();//Error
        //return this.getClass();
        //return T.class;//Error

        return null;
    }

    public <T> T getGeneric (String str , Class<T> ct){
        T a = null;
        return a;
    }

}
