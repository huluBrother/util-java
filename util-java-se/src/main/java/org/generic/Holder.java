package org.generic;

/**
 * 传统写法
 * 强制转换 基于祖先类Object
 */
public class Holder {
    private Object obj;

    public Holder(Object obj){
        this.obj = obj;
    }

    public void set(Object o){
        this.obj = o;
    }
    public Object get(){
        return this.obj;
    }


    public static void main(String[] args) {
        Holder  holder = new Holder("not generic");
        String s = (String)holder.get();
        System.out.println(s);
        holder.set(1);
        Integer x = (Integer)holder.get();
        System.out.println(x);

    }
}
