package org.reflection;

public class ClassDemo {
    public static void main(String[] args) {
        String name = "caterpillar";
        Class stringClass = name.getClass();
        System.out.println("类别名称:" + stringClass.getName());
        System.out.println("是否是接口:" + stringClass.isInterface());
        System.out.println("是否是基本形态:" + stringClass.isPrimitive());
        System.out.println("是否是数组:" + stringClass.isArray());
        System.out.println("是否是注解:" + stringClass.isAnnotation());
        System.out.println("父类名称:" + stringClass.getSuperclass().getName());

        System.out.println(stringClass ==  String.class);
    }
}