package org.generic;

/**
 * 类型擦除导致泛型丧失了一些功能，任何在运行期需要知道确切类型的代码都无法工作
 * @param <T>
 */
public class Erased<T>{
    private final int SIZE = 100;
    public static void f(Object arg) {
        //Error:(10, 27) java: 无法从静态上下文中引用非静态 类型变量 T
        //if(arg instanceof T) {} // Error

        //Error:(14, 7) java: 无法从静态上下文中引用非静态 类型变量 T
        //T var; // Error
        //T var = new T();
        //T[] array = new T[SIZE]; // Error
        //T[] array = (T)new Object[SIZE]; // Unchecked warning
    }

    public static void main(String[] args) {
        System.out.println("erased 弊端");
    }
}
