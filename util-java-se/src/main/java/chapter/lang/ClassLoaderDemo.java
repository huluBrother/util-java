package chapter.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  使用应用程序类加载显示ClassLoader的API
 */
public class ClassLoaderDemo {

    public static Logger logger = LoggerFactory.getLogger("ClassLoaderDemo");

    //1. 通过字节数组类加载类
    /**
     * protected Class<?>	defineClass(String name, byte[] b, int off, int len)
     * 将字节数组转换为类别 类的实例。
     * protected Class<?>	defineClass(String name, byte[] b, int off, int len, ProtectionDomain protectionDomain)
     * 将字节数组转换为类别 类的实例，其中可选的是 ProtectionDomain 。
     * protected Class<?>	defineClass(String name, ByteBuffer b, ProtectionDomain protectionDomain)
     * 一个转换ByteBuffer到类类的实例，带有可选ProtectionDomain。
     */
    //2. 通过文件来加载类
    /**
     * Class<?>	loadClass(String name)
     * 用指定的binary name 加载课程 。
     * protected Class<?>	loadClass(String name, boolean resolve)
     * 加载类别与指定的 binary name 。
     */
    //3. 判断是否已经加载类
    /**
     * protected Class<?>	findClass(String name)
     * 找到具有指定的课程 binary name 。
     * protected Class<?>	findLoadedClass(String name)
     * 返回给定类 binary name如果装载机已记录由Java虚拟机作为与一类的初始化加载器 binary name 。
     * protected Class<?>	findSystemClass(String name)
     * 查找具有指定的类别 binary name ，如果需要加载它。
     */
    //4. 查找库
    /**
     * protected String	findLibrary(String libname)
     * 返回本机库的绝对路径名。
     */
    //5. 包相关操作
    /**
     * protected 软件包	definePackage(String name, String specTitle, String specVersion, String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase)
     * 在这个 ClassLoader中按名称定义一个包。
     * protected 软件包	getPackage(String name)
     * 返回已经被这个类加载器或其任何祖先所定义的 Package。
     * protected 软件包[]	getPackages()
     * 返回所有此类加载器及其祖先所定义的 Packages的。
     */

    //6. 资源相关操作
    /**
     * protected URL	findResource(String name)
     * 找到具有给定名称的资源。
     * URL	getResource(String name)
     * 找到具有给定名称的资源。
     * InputStream	getResourceAsStream(String name)
     * 返回用于读取指定资源的输入流。
     * Enumeration<URL>	getResources(String name)
     * 查找具有给定名称的所有资源。
     * protected Enumeration<URL>	findResources(String name)
     * 返回表示具有给定名称的所有资源的URL对象的枚举。
     * static URL	getSystemResource(String name)
     * 从用于加载类的搜索路径中查找指定名称的资源。
     * static InputStream	getSystemResourceAsStream(String name)
     * 打开阅读，从用于加载类的搜索路径中指定名称的资源。
     * static Enumeration<URL>	getSystemResources(String name)
     * 从用于加载类的搜索路径中查找指定名称的所有资源。
     */

    //7. 断言相关
    /**
     * void	clearAssertionStatus()
     * 将此类加载器的默认断言状态设置为 false ，并丢弃与类加载器相关 联的任何包默认值或类断言状态设置。
     * void	setClassAssertionStatus(String className, boolean enabled)
     * 为此类加载器中指定的顶级类和其中包含的任何嵌套类设置所需的断言状态。
     * void	setDefaultAssertionStatus(boolean enabled)
     * 设置此类加载器的默认断言状态。
     * void	setPackageAssertionStatus(String packageName, boolean enabled)
     * 设置命名包的包默认断言状态。
     */

    //8. 其他方法
    /**
     * protected Object	getClassLoadingLock(String className)
     * 返回类加载操作的锁定对象。
     * protected static boolean	registerAsParallelCapable()
     * 将呼叫者注册为并行功能。
     * protected void	resolveClass(类<?> c)
     * 链接指定的类。
     * protected void	setSigners(类<?> c, Object[] signers)
     * 设置一个类的签名者。
     */

    public static void main(String[] args) throws ClassNotFoundException {
        //public方法

        //返回用于委派的系统类加载器。 这是新的ClassLoader实例的默认委派父项， 通常是用于启动应用程序的类加载器。
        logger.info(" 返回委派的类加载器 {} ",ClassLoader.getSystemClassLoader());
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        logger.info(" 返回父类加载器进行委派 {} ",loader.getParent());
        logger.info(" 清理断言状态 clearAssertionStatus()");

        //找到具有给定名称的资源。 资源是可以通过独立于代码位置的方式由类代码访问的一些数据（图像，音频，文本等）。
        //getResource(String name)
        //getResources(String name)
        //getResourceAsStream(String name)
        //getSystemResource(String name)
        //static InputStream	getSystemResourceAsStream(String name)
        //static Enumeration<URL>	getSystemResources(String name)

        logger.info(" 加载类 {} ",loader.loadClass("chapter.lang.Error"));

        //setClassAssertionStatus(String className, boolean enabled)
        //void	setDefaultAssertionStatus(boolean enabled)
        //void	setPackageAssertionStatus(String packageName, boolean enabled)
    }

}
