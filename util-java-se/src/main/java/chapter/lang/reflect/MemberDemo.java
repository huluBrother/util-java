package chapter.lang.reflect;

/**
 * Member是一个反映关于单个成员（字段或方法）或构造函数的标识信息的接口。
 */
public interface MemberDemo {

    //返回表示声明该成员表示的成员或构造函数的类或接口的Class对象。
    Class<?>	getDeclaringClass();

    //返回由此成员表示的成员或构造函数的Java语言修饰符，作为整数。
    int	getModifiers();

    //返回由此成员表示的基础成员或构造函数的简单名称。
    String	getName();

    //如果此成员由编译器引入，则返回true ; 返回false其他。
    boolean	isSynthetic();

}
