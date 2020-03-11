package org.generic;

/**
 * 利用边界解决类型擦除我呢提
 */
public class Manipulator2<T extends HasF>{
    private T obj;
    public Manipulator2(T a){
        this.obj = a;
    }
    public void manipulate(){
        obj.f();
    }

    public static void main(String[] args) {
        HasF hasF  = new HasF();
        Manipulator2<HasF> manipulator = new Manipulator2<>(hasF);
        manipulator.manipulate();
    }
}
