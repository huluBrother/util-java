package org.generic.erased;


public class Foo2<T>{
    private T x;//类泛型对象

    /**
     *
     * @param factory 一个可以制造类泛型的工厂
     * @param <F>
     */
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create(0);
        System.out.println("create object " + x);
    }

    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());

    }
}
