package chapter.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 软件包对象包含有关Java包的实现和规范的版本信息。
 * 该版本信息由加载该类的ClassLoader实例检索并提供。
 * 通常，它存储在与类分发的清单中
 */
public class PackageDemo {
    public static Logger logger = LoggerFactory.getLogger(PackageDemo.class);

    public static void main(String[] args) {
        try{
            //静态方法
            // classLoader 类的理解********************
            Package[] packages = Package.getPackages();
            for(Package pk : packages){
                logger.info("{} ",pk.getName());
            }
            logger.info("共计 {} 个包",packages.length);
            Package findPackage = Package.getPackage("java.lang");
            logger.info("查找结果 {}",findPackage.getName());

            Package pka = Class.forName("java.lang.Package").getPackage();
            pka = Class.forName("org.slf4j.Logger").getPackage();
            logger.info(">>>>>> {} ","和名字有关的方法");
            //返回此包的字符串表示形式。
            logger.info(" toString ={}",pka.toString());
            //返回此包的名称。
            logger.info(" 名字 name ={}",pka.getName());

            //返回此包的标题。
            logger.info(" 标题 getImplementationTitle ={}",pka.getImplementationTitle());
            //返回此包的提供者
            logger.info(" 提供者 getImplementationVendor ={}",pka.getImplementationVendor());
            //返回此包的提供者
            logger.info(" 提供版本 getImplementationVersion ={}",pka.getImplementationVersion());

            //返回此程序包实现的规范的标题。
            logger.info(" 规范标题 getSpecificationTitle = {}", pka.getSpecificationTitle());
            //规范的提供者
            logger.info(" 规范提供者 getSpecificationVendor = {}", pka.getSpecificationVendor());
            //规范版本
            logger.info(" 规范版本 getSpecificationVersion = {}", pka.getSpecificationVersion());
            //是否封装
            logger.info("是否封装密封 isSealed(URL){}",pka.isSealed());
            //包的版本
            logger.info("包版本比较 当前版本(isCompatibleWith) {} 是否大于参数{} 版本 = {}",
                pka.getImplementationVersion(),"1.10",pka.isCompatibleWith("1.7.25"));
            //包上允许有注解,三组方法
            //<A extends Annotation> A	getAnnotation(Class<A> annotationClass)
            //返回该元素的，如果这样的注释 ，否则返回null指定类型的注释
            //Annotation[]	getAnnotations()
            //返回此元素上 存在的注释。
            logger.info("第一组注解形式");
            //Annotation[]	getDeclaredAnnotations()
            //返回 直接存在于此元素上的注释。
            //<A extends Annotation>A	getDeclaredAnnotation(Class<A> annotationClass)
            //如果这样的注释 直接存在 ，则返回指定类型的元素注释，否则返回null
            logger.info("第二组注解形式");
            //<A extends Annotation>A[]	getAnnotationsByType(Class<A> annotationClass)
            //返回与此元素相关 联的注释 。
            //<A extends Annotation> A[]	getDeclaredAnnotationsByType(Class<A> annotationClass)
            //如果此类注释 直接存在或 间接存在，则返回该元素的注释（指定类型）。
            logger.info("第三组注解形式");

            //查找方法
            //boolean	isAnnotationPresent(Class <? extends Annotation> annotationClass)
            //如果此元素上 存在指定类型的注释，则返回true，否则返回false。
            logger.info("查找方法 isAnnotationPresent");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
