package org.lang;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<? extends ZHXClass> aClass = Class.forName("org.lang.ZHXClass", false,
                Thread.currentThread().getContextClassLoader()).asSubclass(ZHXClass.class);
        System.out.println("对象加载完成,没有初始化静态内容");
        ZHXClass zhxClass = aClass.newInstance();
        System.out.println("静态方法初始化完成");
//        zhxClass1.testForName3();
    }
}
