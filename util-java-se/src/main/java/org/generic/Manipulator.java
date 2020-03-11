package org.generic;

public class Manipulator<T> {
    private T obj;

    public Manipulator(T obj){
        this.obj = obj;
    }

    public void manipulate(){
        /**
         *    Error:(16, 12) java: 找不到符号
         *   符号:   方法 f()
         *   位置: 类型为T的变量 obj
         */
        //obj.f();
    }

    public static void main(String[] args) {
        System.out.println("类型擦除");
        HasF hasF  = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hasF);
        manipulator.manipulate();
    }
}


