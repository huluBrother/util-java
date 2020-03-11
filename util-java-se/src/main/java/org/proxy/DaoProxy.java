package org.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DaoProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
                );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        System.out.println(proxy.getClass().getCanonicalName());
        Object ret = method.invoke(this.target,args);
        commit();
        return ret;
    }

    public void log(String name) {
        System.out.println("执行日志记录" + name);
    }

    public void commit() {
        System.out.println("执行事务提交");
    }
}
