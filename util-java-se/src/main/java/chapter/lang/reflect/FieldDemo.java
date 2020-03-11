package chapter.lang.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 提供有关类或接口的单个字段的信息和动态访问。
 * 反射的字段可以是类（静态）字段或实例字段。
 */
public class FieldDemo {
    public static Logger logger = LoggerFactory.getLogger(FieldDemo.class);

    public static final String CLASSNAME = "ZHX";
    private static final int CLASSSAGE = 20;

    public String name;
    private int age;
    public FieldDemo next;

    public FieldDemo(){

    }

    public FieldDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FieldDemo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }


    // 1. 名字相关
    /**
     * 返回由此 Field对象表示的字段的名称。
     * String	getName()
     *
     * 返回描述此 Field的字符串，包括其通用类型。
     * String	toGenericString()
     *
     * 返回一个描述这个 Field的字符串。
     * String	toString()
     */

    //2. 设置值
    /**
     * 将指定对象参数上的此 Field对象表示的字段设置为指定的新值。
     * void	set(Object obj, Object value)
     *
     * 设置作为一个字段的值 boolean指定的对象上。
     * void	setBoolean(Object obj, boolean z)
     *
     * 设置作为一个字段的值 byte指定的对象上。
     * void	setByte(Object obj, byte b)
     *
     * 设置作为一个字段的值 char指定的对象上。
     * void	setChar(Object obj, char c)
     *
     * 设置作为一个字段的值 double指定的对象上。
     * void	setDouble(Object obj, double d)
     *
     * 设置作为一个字段的值 float指定的对象上。
     * void	setFloat(Object obj, float f)
     *
     * 设置作为一个字段的值 int指定的对象上。
     * void	setInt(Object obj, int i)
     *
     * 设置作为一个字段的值 long指定的对象上。
     * void	setLong(Object obj, long l)
     *
     * 设置作为一个字段的值 short指定的对象上。
     * void	setShort(Object obj, short s)
     *
     */

    // 3. 取值函数
    /**
     * 返回该所表示的字段的值 Field ，指定的对象上。
     * Object	get(Object obj)
     *
     * 获取静态或实例的值 boolean字段。
     * boolean	getBoolean(Object obj)
     *
     * 获取静态或实例的值 byte字段。
     * byte	getByte(Object obj)
     *
     * 获取类型为 char的静态或实例字段的值，或通过扩大转换获得可转换为类型 char的另一个原始类型的值。
     * char	getChar(Object obj)
     *
     * 获取类型为 double的静态或实例字段的值，或通过扩展转换转换为类型 double的另一个基本类型的值。
     * double	getDouble(Object obj)
     *
     * 获取类型为 float的静态或实例字段的值，或通过加宽转换转换为类型 float的另一个基本类型的值。
     * float	getFloat(Object obj)
     *
     * 获取类型为 int的静态或实例字段的值，或通过扩展转换转换为类型 int的另一个原始类型的值。
     * int	getInt(Object obj)
     *
     * 获取类型为 long的静态或实例字段的值，或通过扩大转换获得可转换为类型 long的另一个基本类型的值。
     * long	getLong(Object obj)
     *
     * 获取类型为 short的静态或实例字段的值，或通过加宽转换转换为类型 short的另一个基本类型的值。
     * short	getShort(Object obj)
     *
     */

    // 4. 描述符号
    /**
     * int	getModifiers()
     * 返回由该 Field对象表示的字段的Java语言修饰符，作为整数。
     */

    // 5. 数据类型
    /**
     * 返回一个 Type对象，它表示由该表示的字段的声明类型 Field对象。
     * Type	getGenericType()
     *
     * 返回一个 类对象标识了此表示的字段的声明类型 Field对象。
     * Class<?>	getType()
     *
     * 返回一个AnnotatedType对象，该对象表示使用类型来指定此Field所表示的字段的声明类型。
     * AnnotatedType	getAnnotatedType()
     *
     */

    // 6. 类
    /**
     * 返回表示 类对象表示的字段的类或接口的 Field对象。
     * Class<?>	getDeclaringClass()
     */

    // 7. 字段上的注解
    /**
     * 返回该元素的，如果这样的注释 ，否则返回null指定类型的注释。
     * <T extends Annotation> T	getAnnotation(类<T> annotationClass)
     *
     * 返回与此元素相关联的注释 。
     * <T extends Annotation> T[]	getAnnotationsByType(Class<T> annotationClass)
     *
     * 返回 直接存在于此元素上的注释。
     * Annotation[]	getDeclaredAnnotations()
     *
     */

    // 8. 其他
    /**
     * 如果此字段表示枚举类型的元素，则返回true ; 返回false其他。
     * boolean	isEnumConstant()
     *
     * 如果此字段是合成字段，则返回true ; 返回false其他。
     * boolean	isSynthetic()
     *
     */


    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        FieldDemo demo = new FieldDemo("zhx",25);
        System.out.println(demo);
        Field[] fields = demo.getClass().getDeclaredFields();
        //fields = String.class.getDeclaredFields();

        for(Field field : fields){
            logger.info("{} {} {} ", Modifier.toString(field.getModifiers()),field.getType().getName(),field.getName());
        }
        for(Field field : fields){
            logger.info("{} ", field.toGenericString());
        }

        logger.info(">>>>>>>>>>>>>>");
        Field f = demo.getClass().getDeclaredField("age");
        f.setInt(demo,100);
        logger.info("设置年龄后 = {}",demo.toString());

        f = demo.getClass().getDeclaredField("name");
        Object o = f.get(demo);
        logger.info("class : {}  value : {}",o.getClass().getCanonicalName(),o.toString());
        f = demo.getClass().getDeclaredField("age");
        int anInt = f.getInt(demo);
        logger.info(" age = {}" ,anInt);

    }

}
