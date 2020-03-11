package org.generic;

/**
 * 基础泛型
 * 泛型因为类型擦除不能直接实例化
 * @param <T>
 */
public class Holder2 <T>{
    public T a;

    public Holder2(T a){
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2<String> holder2  = new Holder2<>("generic");
        String s = holder2.getA();
        System.out.println(s);

        holder2.setA("set Method String");
        s = holder2.getA();
        System.out.println(s);


        //holder2.setA(1);//Error:(33, 22) java: 不兼容的类型: int无法转换为java.lang.String
    }
}
