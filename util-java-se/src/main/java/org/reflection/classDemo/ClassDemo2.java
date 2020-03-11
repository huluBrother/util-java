package org.reflection.classDemo;

public class ClassDemo2 {

    public void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        System.out.println(Void.class);
        System.out.println(Boolean.class);
        int array[] = new int[10];
        System.out.println(array.getClass().toString());//[I
        ClassDemo2 classArray[] = new ClassDemo2[10];
        System.out.println(classArray.getClass().toString());

        try {
            //Class<ClassDemo2> demo = Class.forName("org.reflection.classDemo.ClassDemo2");
            Class demo = Class.forName("org.reflection.classDemo.ClassDemo2");
            System.out.println("forName() " + demo.getClass().getName() + " : " +
                        demo.getName());

            Class demo2 = Class.forName("org.reflection.classDemo.ClassDemo2",false,
                    Thread.currentThread().getContextClassLoader());
            System.out.println("forName(3) " + demo2.getClass().getName() + " : " +
                        demo2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
