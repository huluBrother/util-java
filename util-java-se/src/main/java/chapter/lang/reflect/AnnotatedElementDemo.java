package chapter.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * 表示当前在此VM中运行的程序的注释元素。
 * 该界面允许反射读取注释。
 * 通过这个接口方法返回的所有注释都是不可变并且可序列化。
 * 通过此接口的方法返回的阵列可以调用，而不会影响其他调用者返回阵列进行修改。
 */
public interface AnnotatedElementDemo {

    //返回此元素上 存在的注释。
    Annotation[]	getAnnotations();

    //返回该元素的，如果这样的注释 ，否则返回null指定类型的注释。
    <T extends Annotation> T getAnnotation(Class<T> annotationClass);


    //返回 直接存在于此元素上的注释。
    Annotation[]	getDeclaredAnnotations();

    //如果此类注释 直接存在或 间接存在，则返回该元素的注释（指定类型）。
    default <T extends Annotation> T[]	getDeclaredAnnotationsByType(Class<T> annotationClass){
        return null;
    }

    //返回与此元素相关 联的注释 。
    default <T extends Annotation> T[]	getAnnotationsByType(Class<T> annotationClass){
        return null;
    }

    //如果这样的注释 直接存在 ，则返回指定类型的元素注释，否则返回null。
    default <T extends Annotation> T	getDeclaredAnnotation(Class <T> annotationClass){
        return null;
    }



    //如果此元素上 存在指定类型的注释，则返回true，否则返回false。
    default boolean	isAnnotationPresent(Class<? extends Annotation> annotationClass){
        return false;
    }
}
