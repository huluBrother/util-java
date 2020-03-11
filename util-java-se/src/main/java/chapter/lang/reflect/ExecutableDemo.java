package chapter.lang.reflect;

public class ExecutableDemo {



    /**
     * AnnotatedType[]	getAnnotatedExceptionTypes()
     * 返回一个 AnnotatedType对象的数组， AnnotatedType使用类型来指定由此可执行文件表示的方法/构造函数声明的异常。
     * AnnotatedType[]	getAnnotatedParameterTypes()
     * 返回一个 AnnotatedType对象的数组， AnnotatedType使用类型来指定此可执行文件所表示的方法/构造函数的形式参数类型。
     * AnnotatedType	getAnnotatedReceiverType()
     * 返回一个 AnnotatedType对象，该对象表示使用类型来指定此可执行文件对象所表示的方法/构造函数的接收器类型。
     * abstract AnnotatedType	getAnnotatedReturnType()
     * 返回一个 AnnotatedType对象，表示使用一个类型来指定此可执行文件所表示的方法/构造函数的返回类型。
     * <T extends Annotation> T	getAnnotation(类<T> annotationClass)
     * 返回该元素的，如果这样的注释 ，否则返回null指定类型的注释。
     * <T extends Annotation> T[]	getAnnotationsByType(类<T> annotationClass)
     * 返回与此元素相关 联的注释 。
     * Annotation[]	getDeclaredAnnotations()
     * 返回 直接存在于此元素上的注释。
     * abstract Class<?>	getDeclaringClass()
     * 返回 类表示声明该对象表示的可执行的类或接口对象。
     * abstract Class<?>[]	getExceptionTypes()
     * 返回一个 类对象的数组， 类表示由该对象表示的底层可执行文件抛出的异常类型。
     * Type[]	getGenericExceptionTypes()
     * 返回一个 Type对象的数组， Type表示声明为该可执行对象抛出的异常。
     * Type[]	getGenericParameterTypes()
     * 返回一个 Type对象的数组， Type以声明顺序表示由该对象表示的可执行文件的形式参数类型。
     * abstract int	getModifiers()
     * 返回由该对象表示的可执行文件的Java语言modifiers 。
     * abstract String	getName()
     * 返回由此对象表示的可执行文件的名称。
     * abstract Annotation[][]	getParameterAnnotations()
     * 返回一个 Annotation s的数组数组，表示由该对象表示的Executable的形式参数的声明顺序的 Executable 。
     * int	getParameterCount()
     * 返回由此对象表示的可执行文件的形式参数（无论是显式声明还是隐式声明）的数量。
     * Parameter[]	getParameters()
     * 返回一个 Parameter对象的数组，表示由该对象表示的底层可执行文件的所有参数。
     * abstract Class<?>[]	getParameterTypes()
     * 返回一个 类对象的数组， 类以声明顺序表示由该对象表示的可执行文件的形式参数类型。
     * abstract TypeVariable<?>[]	getTypeParameters()
     * 返回一个 TypeVariable对象的数组，它们以声明顺序表示由此 GenericDeclaration对象表示的通用声明声明的类型变量。
     * boolean	isSynthetic()
     * 返回true如果这个可执行文件是一个合成的构建体; 返回false其他。
     * boolean	isVarArgs()
     * 返回true如果这个可执行文件被宣布为带有可变数量的参数; 返回false否则。
     * abstract String	toGenericString()
     * 返回描述此 Executable的字符串，包括任何类型的参数。
     */
}
