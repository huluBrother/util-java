package org.lang;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.jgss.spi.MechanismFactory;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class 类表示正在运行的JAVA应用程序中的类和接口
 * Class 没有公有的构造函数，是由虚拟机自动构建
 */
public class ZHXClass {
    public Logger logger = LoggerFactory.getLogger(ZHXClass.class);

    static {
        System.out.println("静态方法被执行");
    }

    //静态方法
    // 构建 Class 类
    private void testForName() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "ForName()");
        try {
            //相当于 Class.forName(className, true, currentLoader)
            Class<?> aClass = Class.forName("org.lang.ZHXClass");
            System.out.println(aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("<<<<<<<<<<<{}<<<<<<<<<<<<", "ForName()");
    }

    // 构建Class 类
    private void testForName3() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "ForName(3)");

        try {
            Class<?> aClass1 = Class.forName("org.lang.ZHXClass", true,
                    Thread.currentThread().getContextClassLoader());
            System.out.println(aClass1);
            Class<?> aClass2 = Class.forName("org.lang.ZHXClass", true,
                    this.getClass().getClassLoader());
            System.out.println(aClass2);
            System.out.println(aClass2 == aClass1);

//            //静态方法初始化
//            public class TestClass {
//                public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//                    Class<? extends ZHXClass> aClass = Class.forName("org.lang.ZHXClass", false,
//                            Thread.currentThread().getContextClassLoader()).asSubclass(ZHXClass.class);
//                    System.out.println("对象加载完成,没有初始化静态内容");
//                    ZHXClass zhxClass = aClass.newInstance();
//                    System.out.println("静态方法初始化完成");
//                }
//            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("<<<<<<<<<<<{}<<<<<<<<<<<<", "ForName(3)");
    }

    // 当前调用实例是否是参数的子类，如果不是抛ClassCastException 异常,如果是返回当前对象的引用
    public void testAsSubclass() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "testAsSubclass()");
        try {
            //
            Class<?> aClass3 = Class.forName("org.lang.ZHXSubClass");
            Class<? extends ZHXClass> aClass4 = aClass3.asSubclass(ZHXClass.class);
            System.out.println(aClass4);
            System.out.println(aClass3 == aClass4);//返回值引用相同
            //根据Class对象，实例化为父类对象
            ZHXClass zhxClass = aClass3.asSubclass(ZHXClass.class).newInstance();
            System.out.println(zhxClass);
            //失败情况
            Class<? extends ZHXSubClass> aClass = Class.forName("org.lang.ZHXClass").asSubclass(ZHXSubClass.class);
            System.out.println(aClass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            logger.error("不是其子类");
        }
        logger.info("<<<<<<<<<<<{}<<<<<<<<<<<<", "testAsSubclass()");
    }

    //安全的强制转化对象
    public void testCast() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "testCast()");
        try {
            //同类可以转换
            ZHXClass runnableClass = new ZHXClass();
            ZHXClass cast = ZHXClass.class.cast(runnableClass);
            System.out.println(runnableClass == cast);
            //子类可以转换
            ZHXSubClass subClass = new ZHXSubClass();
            ZHXClass cast1 = ZHXClass.class.cast(subClass);
            System.out.println(cast1 == subClass);
            //空对象
            ZHXClass cast3 = ZHXClass.class.cast(null);
            System.out.println(cast3);
            //父类转子类
            ZHXSubClass cast2 = ZHXSubClass.class.cast(runnableClass);
            System.out.println(cast2 == runnableClass);

        } catch (ClassCastException e) {
//            e.printStackTrace();
        }
        logger.info("<<<<<<<<<<<{}<<<<<<<<<<<<", "testCast()");
    }

    //判断Class 类型的一些方法
    public void testIsMethod() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "testCast()");
        try {
            Class cla = Class.forName("org.lang.ZHXClass", true, Thread.currentThread().getContextClassLoader());
            //判断类 类型
            System.out.println("是否是 注解" + cla.isAnnotation());
            System.out.println("是否是 基础类的匿名类" + cla.isAnonymousClass());
            System.out.println("是否是 数组" + cla.isArray());
            System.out.println("是否是 指定类型的超类" + cla.isAssignableFrom(ZHXSubClass.class));
            System.out.println("是否是 枚举类型" + cla.isEnum());
            System.out.println("是否是 指定类型的子类 " + cla.isInstance(new Object()));//instanceof 等价类
            System.out.println("是否是 指定类型的接口 " + cla.isInterface());
            System.out.println("是否是 本地类 " + cla.isLocalClass());
            System.out.println("是否是 成员类 " + cla.isMemberClass());
            System.out.println("是否是 基本类 " + cla.isPrimitive());
            System.out.println("是否是 合成类 " + cla.isSynthetic());


            System.out.println("是否是" + cla);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        logger.info("<<<<<<<<<<<{}<<<<<<<<<<<<", "testCast()");
    }


    public void testAnnotation(){

    }

    public void testGetMethod() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "testCast()");
        try {
            Class cla = Class.forName("java.lang.String");


            //所有实现的接口
            AnnotatedType[] annotatedInterfaces = cla.getAnnotatedInterfaces();
            System.out.println("AnnotatedType : " + annotatedInterfaces.length);
            for(AnnotatedType annotatedType: annotatedInterfaces){
                System.out.println(annotatedType.getType());
            }

            // 不带 接口的父类
            AnnotatedType annotatedSuperclass = Class.forName("org.lang.ZHXSubClass").getAnnotatedSuperclass();
            System.out.println(annotatedSuperclass.getType());


            // 所有实现的注解
            Class cla1  = Class.forName("org.lang.ZHXClass");
            Annotation[] annotations = cla1.getAnnotations();
            System.out.println("Annotation : " + annotations.length);
            for(Annotation annotation : annotations){
                System.out.println(annotation.annotationType());
            }

            //判断是否由注解
            Class cla2 = Class.forName("java.lang.Thread");
            Annotation annotation = cla2.getAnnotation(String.class);
            System.out.println(annotation);

            //返回直接注释在上面的所有注解
            Annotation[] declaredAnnotations = Class.forName("java.lang.Object").getDeclaredAnnotations();
            System.out.println("getDeclaredAnnotations 大小 ; " + declaredAnnotations.length);
            for(Annotation declaredAnnotation : declaredAnnotations){
                System.out.println("getDeclaredAnnotations --》" + declaredAnnotation.annotationType());
            }

            // 返回规范名称
            System.out.println(cla2.getCanonicalName());

            //返回 该类声明的公有类和接口
            Class cla3 = Class.forName("java.util.HashMap");
            Class[] classes = cla3.getClasses();
            System.out.println("Classes length = " + classes.length );
            for(Class c : classes){
                System.out.println("Classes -->" + c.getCanonicalName());
            }

            //返回类加载器
            ClassLoader classLoader = cla1.getClassLoader();
            System.out.println("类加载器(同一祖先): " + classLoader);
            System.out.println("类加载器(不同): " + cla3.getClassLoader());

            // 返回数组类的Class
            Class componentType = cla1.getComponentType();
            System.out.println(componentType);
            int array[] = new int[10];
            Class<? extends int[]> aClass = array.getClass();
            System.out.println(aClass.getComponentType().getCanonicalName());

            // 返回公有构造函数
            Constructor[] constructors = cla2.getConstructors();
            System.out.println("Constructor : " + constructors.length);
            for(Constructor constructor : constructors){
                System.out.println("Constructor--->" + constructor.getName());
            }

            //测试方法
            Class classList = Class.forName("org.lang.ZHXClass");
            Method[] methods = classList.getMethods();
            for(Method methon : methods){
                System.out.println("---》" + methon.toGenericString());
            }
            System.out.println("---------------");
            Method[] declaredMethods = classList.getDeclaredMethods();
            for(Method method : declaredMethods){
                System.out.println("---> " + method.toGenericString());
            }
            System.out.println(methods.length);
            System.out.println(declaredMethods.length);

            //
//            Class aClass1 = Class.forName("org.lang.ZHXSubClass");
//            Field[] fields = aClass1.getFields();
//            for(Field field : fields){
//                System.out.println(field);
//            }
//            Field[] declaredFields = aClass1.getDeclaredFields();
//            for(Field field : declaredFields){
//                System.out.println(field);
//            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("<<<<<<<<<<<{}<<<<<<<<<<<<", "testCast()");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "testCast()");
//    logger.info("<<<<<<<<<<<{}<<<<<<<<<<<<", "testCast()");

    // 静态方法
    public static void main(String[] args) {
        try {
            ZHXClass cla = new ZHXClass();
//            cla.testForName3();
//            cla.testAsSubclass();
//            cla.testCast();
//            cla.testIsMethod();
            cla.testGetMethod();

        } finally {

        }
    }
}
