package chapter.lang;

/**
 * 是所有类层次结构的根
 * registerNatives
 *      1. 给本地的native 函数改名映射，暂时不要管
 * hashCode
 *      1. 提供一个整数哈希值。如果不修改值，程序执行期间，对象返回的值固定，不同程序之间不需要保持一致
 *      2. equal 返回 true ，hashcode 必须相同， 返回false，hashcode 不做要求
 * equals
 *      自反、对称、传递三原则
 * clone
 *      没有硬性要求的拷贝函数
 * getClass()
 *      返回运行时类对象， 和反射动态加载机制有关
 * finalize()
 *      和GC 有关
 * toString()
 *      打印日志
 * wait()
 *      和线程有关，
 * notify()
 *      和线程有关
 */
public class ObjectDemo {


    public static void main(String[] args) {
        Object object = new Object();

    }
}
