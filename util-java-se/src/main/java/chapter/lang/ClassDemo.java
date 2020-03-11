package chapter.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Modifier;


/**
 * Class类的类表示正在运行的Java应用程序中的类和接口。
 * 枚举是一种类，一个注释是一种接口。
 * 每个数组也属于一个反映为类对象的类，该对象由具有相同元素类型和维数的所有数组共享。
 * 原始Java类型（ boolean ， byte ， char ， short ， int ， long ， float和double ），和关键字void也表示为Class对象。
 */
public class ClassDemo {

    public Logger logger = LoggerFactory.getLogger(ClassDemo.class);

    static {
        System.out.println("静态方法被执行");
    }

    public static class SubClassDemo extends ClassDemo{
        //创建子类
    }

    /**
     * 获取Class实例的三种方式为：XXX.getClass()、XXX.class、 Class.forName；
     * new ClassDemo().getClass()
     * ClassDemo.class
     * Class.forName("chapter.lang.ClassDemo")
     */
    //


    // 1. Class的获取方式
    /**
     * 返回与给定字符串名称的类或接口相关联的 类对象。
     * static Class<?>	forName(String className)
     *
     * 使用给定的类加载器返回与给定字符串名称的类或接口相关联的 类对象。
     * static Class<?>	forName(String name, boolean initialize, ClassLoader loader)
     *
     */

    //2. 获取对象的名字
    /**
     * 返回由Java语言规范定义的基础类的规范名称。
     * String	getCanonicalName()
     *
     * 返回由 类对象表示的实体（类，接口，数组类，原始类型或空白）的名称，作为 String 。
     * String	getName()
     *
     * 返回源代码中给出的基础类的简单名称。
     * String	getSimpleName()
     *
     * 为此类型的名称返回一个内容丰富的字符串。
     * String	getTypeName()
     *
     * 返回描述此 类的字符串，包括有关修饰符和类型参数的信息。
     * String	toGenericString()
     *
     * 将对象转换为字符串。
     * String	toString()
     */

    // 3 和类加载器相关的
    /**
     * 返回类的类加载器。
     * ClassLoader	getClassLoader()
     *
     */

    // 4. 和Package 相关的
    /**
     * 获取此类的包。
     * Package	getPackage()
     */

    // 5. 和 Modifier 相关的
    /**
     * 返回此类或接口的Java语言修饰符，以整数编码。
     * int	getModifiers()
     */

    // 6. 和 Class相关的

    // 7. 和 Interface 相关的

    // 8. 和 Annotation 相关的

    // 9 和 Constructor 相关的

    // 10. 和 Method 相关的

    // 11. 和 Field 相关的

    // 12. 和Resource 相关的


    // 构建Class 类
    private void testForName3() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "ForName(3)");

        try {
            //相当于 Class.forName(className, true, currentLoader)
            Class<?> aClass = Class.forName("java.lang.String");
            System.out.println(aClass.getName());
            Class<?> aClass1 = Class.forName("java.lang.String", true,
                    Thread.currentThread().getContextClassLoader());
            System.out.println(aClass1);
            Class<?> aClass2 = Class.forName("java.lang.String", true,
                    this.getClass().getClassLoader());
            System.out.println(aClass2);
            System.out.println("同属于一个类加载的Class 相同" + (aClass2 == aClass1));

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


    public void testNameRelevant() throws ClassNotFoundException {
        String binaryName = "java.lang.String";
        Class cla = Class.forName(binaryName);
        logger.info("getName() = {}",cla.getName());
        logger.info("getCanonicalName() = {}",cla.getCanonicalName());
        logger.info("getSimpleName() = {}",cla.getSimpleName());
        logger.info("getTypeName() = {}",cla.getTypeName());
        logger.info("toGenericString() = {}",cla.toGenericString());
        logger.info("toString() = {}",cla.toString());
    }

    public void testClassLoader() throws ClassNotFoundException {
        String binaryName = "java.lang.String";
        Class cla = Class.forName(binaryName);
        logger.info(" getClassLoader() ", cla.getClassLoader());
    }

    public void testGetPackage() throws ClassNotFoundException {
        // 加载系统类
        Class cla = Class.forName("java.lang.String");
        Package aPackage = cla.getPackage();
        System.out.println(aPackage);

        //加载自定义类
        cla = Class.forName("chapter.lang.ClassDemo");
        aPackage = cla.getPackage();
        System.out.println(aPackage);
    }

    public void testGetModifier() throws ClassNotFoundException {
        String binaryName = "java.lang.String";
        Class cla = Class.forName(binaryName);
        logger.info(" 系统类 getModifiers() ={} {}", cla.getModifiers(), Modifier.toString(cla.getModifiers()));
        logger.info(" 自定义类 getModifiers() ={} {}", ClassDemo.class.getModifiers(),Modifier.toString(ClassDemo.class.getModifiers()));
    }


    /**
     * <U> Class<? extends U>	asSubclass(Class<U> clazz)
     * 类这个 类对象来表示由指定的类对象表示的类的子类。
     * T cast(Object obj)
     * 施放一个目的是通过本表示的类或接口 类对象。
     * boolean	desiredAssertionStatus()
     * 如果要在调用此方法时初始化该类，则返回将分配给此类的断言状态。
     * AnnotatedType[]	getAnnotatedInterfaces()
     * 返回一个 AnnotatedType对象的数组， AnnotatedType使用类型指定由此 AnnotatedType对象表示的实体的超级 类 。
     * AnnotatedType	getAnnotatedSuperclass()
     * 返回一个 AnnotatedType对象，该对象表示使用类型来指定由此 类对象表示的实体的 类类。
     * <A extends Annotation> A	getAnnotation(Class<A> annotationClass)
     * 返回该元素的，如果这样的注释 ，否则返回null指定类型的注释。
     * Annotation[]	getAnnotations()
     * 返回此元素上 存在的注释。
     * <A extends Annotation> A[]	getAnnotationsByType(Class<A> annotationClass)
     * 返回与此元素相关 联的注释 。
     * Class<?>[]	getClasses()
     * 返回包含一个数组 类表示所有的公共类和由此表示的类的成员接口的对象 类对象。

     * Class<?>	getComponentType()
     * 返回 类数组的组件类型的Class。
     * Constructor<T>	getConstructor(Class<?>... parameterTypes)
     * 返回一个 Constructor对象，该对象反映 Constructor对象表示的类的指定的公共 类函数。
     * Constructor<?>[]	getConstructors()
     * 返回包含一个数组 Constructor对象反射由此表示的类的所有公共构造 类对象。
     * <A extends Annotation> A	getDeclaredAnnotation(Class<A> annotationClass)
     * 如果这样的注释 直接存在 ，则返回指定类型的元素注释，否则返回null。
     * Annotation[]	getDeclaredAnnotations()
     * 返回 直接存在于此元素上的注释。
     * <A extends Annotation> A[]	getDeclaredAnnotationsByType(Class<A> annotationClass)
     * 如果此类注释 直接存在或 间接存在，则返回该元素的注释（指定类型）。
     * Class<?>[]	getDeclaredClasses()
     * 返回一个反映所有被这个 类对象表示的类的成员声明的类和 类对象的数组。
     * Constructor<T>	getDeclaredConstructor(Class<?>... parameterTypes)
     * 返回一个 Constructor对象，该对象反映 Constructor对象表示的类或接口的指定 类函数。
     * Constructor<?>[]	getDeclaredConstructors()
     * 返回一个反映 Constructor对象表示的类声明的所有 Constructor对象的数组 类 。
     * Field	getDeclaredField(String name)
     * 返回一个 Field对象，它反映此表示的类或接口的指定已声明字段 类对象。
     * Field[]	getDeclaredFields()
     * 返回的数组 Field对象反映此表示的类或接口声明的所有字段 类对象。
     * Method	getDeclaredMethod(String name, 类<?>... parameterTypes)
     * 返回一个 方法对象，它反映此表示的类或接口的指定声明的方法 类对象。
     * Method[]	getDeclaredMethods()
     * 返回包含一个数组 方法对象反射的类或接口的所有声明的方法，通过此表示 类对象，包括公共，保护，默认（包）访问和私有方法，但不包括继承的方法。
     * Class<?>	getDeclaringClass()
     * 如果由此 类对象表示的类或接口是另一个类的成员，则返回表示其声明的类的 类对象。
     * Class<?>	getEnclosingClass()
     * 返回底层类的即时封闭类。
     * Constructor<?>	getEnclosingConstructor()
     * 如果此类对象表示构造函数中的本地或匿名类，则返回表示底层类的立即封闭构造函数的Constructor对象。
     * Method	getEnclosingMethod()
     * 如果此类对象表示方法中的本地或匿名类，则返回表示基础类的即时封闭方法的方法对象。
     * T[]	getEnumConstants()
     * 返回此枚举类的元素，如果此Class对象不表示枚举类型，则返回null。
     * Field	getField(String name)
     * 返回一个 Field对象，它反映此表示的类或接口的指定公共成员字段 类对象。
     * Field[]	getFields()
     * 返回包含一个数组 Field对象反射由此表示的类或接口的所有可访问的公共字段 类对象。
     * Type[]	getGenericInterfaces()
     * 返回 Type表示通过由该对象所表示的类或接口直接实现的接口秒。
     * Type	getGenericSuperclass()
     * 返回 Type表示此所表示的实体（类，接口，基本类型或void）的直接超类 类 。
     * Class<?>[]	getInterfaces()
     * 确定由该对象表示的类或接口实现的接口。
     * Method	getMethod(String name, Class<?>... parameterTypes)
     * 返回一个 方法对象，它反映此表示的类或接口的指定公共成员方法 类对象。
     * Method []	getMethods()
     * 返回包含一个数组 方法对象反射由此表示的类或接口的所有公共方法 类对象，包括那些由类或接口和那些从超类和超接口继承的声明。



     * ProtectionDomain	getProtectionDomain()
     * 返回 ProtectionDomain 。
     * URL	getResource(String name)
     * 查找具有给定名称的资源。
     * InputStream	getResourceAsStream(String name)
     * 查找具有给定名称的资源。
     * Object[]	getSigners()
     * 获得这个类的签名者。

     * Class<? super T>	getSuperclass()
     * 返回 类表示此所表示的实体（类，接口，基本类型或void）的超类 类 。

     * TypeVariable<Class<T>>[]	getTypeParameters()
     * 返回一个 TypeVariable对象的数组，它们以声明顺序表示由此 GenericDeclaration对象表示的通用声明声明的类型变量。
     * boolean	isAnnotation()
     * 如果此 类对象表示注释类型，则返回true。
     * boolean	isAnnotationPresent(Class<? extends Annotation> annotationClass)
     * 如果此元素上 存在指定类型的注释，则返回true，否则返回false。
     * boolean	isAnonymousClass()
     * 返回 true当且仅当基础类是匿名类时。
     * boolean	isArray()
     * 确定此 类对象是否表示数组类。
     * boolean	isAssignableFrom(Class<?> cls)
     * 确定由此 类对象表示的类或接口是否与由指定的Class 类表示的类或接口相同或是超类或 类接口。
     * boolean	isEnum()
     * 当且仅当该类在源代码中被声明为枚举时才返回true。
     * boolean	isInstance(Object obj)
     * 确定指定的Object是否与此 Object表示的对象分配 类 。
     * boolean	isInterface()
     * 确定指定 类对象表示接口类型。
     * boolean	isLocalClass()
     * 返回 true当且仅当基础类是本地类时。
     * boolean	isMemberClass()
     * 返回 true当且仅当基础类是成员类时。
     * boolean	isPrimitive()
     * 确定指定 类对象表示一个基本类型。
     * boolean	isSynthetic()
     * 如果这个类是一个合成类，返回true ; 返回false其他。
     * T	newInstance()
     * 创建由此 类对象表示的类的新实例。

     */







    // 当前调用实例是否是参数的子类，如果不是抛ClassCastException 异常,如果是返回当前对象的引用
    public void testAsSubclass() {
        logger.info(">>>>>>>>>>>{}>>>>>>>>>>>>", "testAsSubclass()");
        try {
            //
            Class<?> aClass3 = Class.forName("chapter.lang.ClassDemo");
            Class<? extends ClassDemo> aClass4 = aClass3.asSubclass(ClassDemo.class);
            System.out.println(aClass4);
            System.out.println(aClass3 == aClass4);//返回值引用相同
            //根据Class对象，实例化为父类对象
            ClassDemo zhxClass = aClass3.asSubclass(ClassDemo.class).newInstance();
            System.out.println(zhxClass);
            //失败情况
            Class<? extends SubClassDemo> aClass = Class.forName("java.lang.String").asSubclass(SubClassDemo.class);
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
            ClassDemo runnableClass = new ClassDemo();
            ClassDemo cast = ClassDemo.class.cast(runnableClass);
            System.out.println(runnableClass == cast);
            //子类可以转换
            SubClassDemo subClass = new SubClassDemo();
            ClassDemo cast1 = ClassDemo.class.cast(subClass);
            System.out.println(cast1 == subClass);
            //空对象
            ClassDemo cast3 = ClassDemo.class.cast(null);
            System.out.println(cast3);
            //父类转子类
            SubClassDemo cast2 = SubClassDemo.class.cast(runnableClass);
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
            Class cla = Class.forName("java.lang.String", true, Thread.currentThread().getContextClassLoader());
            //判断类 类型
            System.out.println("是否是 注解" + cla.isAnnotation());
            System.out.println("是否是 基础类的匿名类" + cla.isAnonymousClass());
            System.out.println("是否是 数组" + cla.isArray());
            System.out.println("是否是 指定类型的超类" + cla.isAssignableFrom(SubClassDemo.class));
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


    //


    public static void main(String[] args) {
        try{

            ClassDemo cla = new ClassDemo();
            cla.testForName3();
            cla.testNameRelevant();
            cla.testClassLoader();
            cla.testGetPackage();
            cla.testGetModifier();
//        cla.testForName3();
//        cla.testAsSubclass();
//        cla.testCast();
////        cla.testIsMethod();
////            cla.testGetPackage();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
