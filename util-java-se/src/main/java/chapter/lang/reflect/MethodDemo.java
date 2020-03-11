package chapter.lang.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * 提供有关类和接口上单一方法的信息和访问权限。
 * 反映的方法可以是类方法或实例方法(包括抽象方法)
 */
public class MethodDemo {
    public static Logger logger = LoggerFactory.getLogger(MethodDemo.class);

    /**
     * 返回由此 方法对象表示的方法的名称，作为 String 。
     * String	getName()
     *
     * 返回描述此 方法的字符串，包括类型参数。
     * String	toGenericString()
     *
     * 返回一个描述这个 方法的字符串。
     * String	toString()
     */


    /**
     * 返回true如果这个方法是一个桥接方法; 返回false否则。
     * boolean	isBridge()
     *
     * 如果此方法是默认方法，则返回true ; 返回false其他。
     * boolean	isDefault()
     *
     * 返回true如果这个可执行文件是一个合成的构建体; 返回false其他。
     * boolean	isSynthetic()
     *
     * 返回true如果这个可执行文件被宣布为带有可变数量的参数; 返回false其他。
     * boolean	isVarArgs()
     */

    /**
     * 在具有指定参数的 方法对象上调用此 方法对象表示的底层方法。
     * Object	invoke(Object obj, Object... args)
     *
     */

    /**
     * 返回一个 AnnotatedType对象，表示使用类型来指定此可执行文件所表示的方法/构造函数的返回类型。
     * AnnotatedType	getAnnotatedReturnType()
     *
     * 返回一个 Type对象，它表示由该表示的方法的正式返回类型 方法对象。
     * Type	getGenericReturnType()
     *
     * 返回一个 类对象，它表示由该表示的方法的正式返回类型 方法对象。
     * Class<?>	getReturnType()
     */

    /**
     * 返回该元素的，如果这样的注释 ，否则返回null指定类型的注释。
     * <T extends Annotation> T	 getAnnotation(Class<T> annotationClass)
     *
     * 返回 直接存在于此元素上的注释。
     * Annotation[]	getDeclaredAnnotations()
     */

    /**
     * 返回一个 类对象的数组，表示由该对象表示的底层可执行文件所声明的异常类型。
     * Class<?>[]	getExceptionTypes()
     *
     * 返回一个 Type对象的数组， Type此可执行对象声明抛出的异常。
     * Type[]	getGenericExceptionTypes()
     */

    /**
     * int	getParameterCount()
     * 返回由此对象表示的可执行文件的形式参数（无论是显式声明还是隐式声明）的数量。
     * 返回一个 Type对象的数组， Type以声明顺序表示由该对象表示的可执行文件的形式参数类型。
     * Type[]	getGenericParameterTypes()
     * Annotation[][]	getParameterAnnotations()
     * 返回一个 Annotation s的数组数组，表示由该对象表示的Executable的形式参数的声明顺序的 Executable 。
     * Class<?>[]	getParameterTypes()
     * 返回一个 类对象的数组， 类以声明顺序表示由该对象表示的可执行文件的形式参数类型。
     * TypeVariable<Method>[]	getTypeParameters()
     * 返回一个 TypeVariable对象的数组，它们以声明顺序表示由此 GenericDeclaration对象表示的通用声明声明的类型变量。
     */

    /**
     * Class<?>	getDeclaringClass()
     * 返回 类表示声明该对象表示的可执行的类或接口对象。
     */

    /**
     * Object	getDefaultValue()
     * 返回由此 方法实例表示的注释成员的默认值。
     */

    /**
     * int	getModifiers()
     * 返回由该对象表示的可执行文件的Java语言modifiers 。
     */

    public static void main(String[] args) {
        Method[] declaredMethods = String.class.getDeclaredMethods();
        for(Method method : declaredMethods){
            StringBuffer buffer = new StringBuffer();
            buffer.append("(");
            for(Class cla : method.getParameterTypes()){
                buffer.append(cla.getSimpleName()).append(",");
            }
            buffer.append(")");
            for(Class clas : method.getExceptionTypes()){
                buffer.append(clas.getSimpleName());
            }
            logger.info("{}",method.toGenericString());
            logger.info(" {} {} {} {}",
                    Modifier.toString(method.getModifiers()),
                    method.getGenericReturnType().getTypeName(),
                    method.getName(),
                    buffer.toString());
        }
    }

}
