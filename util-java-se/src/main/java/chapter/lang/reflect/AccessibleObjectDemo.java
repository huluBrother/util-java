package chapter.lang.reflect;


/**
 * AccessibleObject类是Field，Method和Constructor对象的基类。
 * 它提供了将反射对象标记为在使用它时抑制默认Java语言访问控制检查的功能。
 * 当使用Fields，Methods或Constructors来设置或获取字段，调用方法，或创建和初始化新的类实例时，
 * 执行访问检查（对于public，默认（包）访问，受保护和私有成员） ， 分别。
 * 在反射对象中设置accessible标志允许具有足够权限的复杂应用程序
 * （如Java对象序列化或其他持久性机制）以通常被禁止的方式操纵对象。
 * 默认情况下，反射对象不可访问。
 */
public class AccessibleObjectDemo {

    /**
     * 获取此对象的 accessible标志的值。
     * boolean	isAccessible()
     *
     * 方便的方法来设置 accessible标志的一系列对象的安全检查（为了效率）。
     * static void	setAccessible(AccessibleObject[] array, boolean flag)
     *
     * 将此对象的 accessible标志设置为指示的布尔值。
     * void	setAccessible(boolean flag)
     */

}
