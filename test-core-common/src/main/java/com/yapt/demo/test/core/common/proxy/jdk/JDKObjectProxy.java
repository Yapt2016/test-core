package com.yapt.demo.test.core.common.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hurui
 * @version Id: JDKObjectProxy.java, v 0.1 2020/9/18 15:37 YaphetS Exp $$
 */
public class JDKObjectProxy implements InvocationHandler {
    private Object target;

    @SuppressWarnings("all")
    public JDKObjectProxy(Object target){
        this.target = target;
    }

    @SuppressWarnings("all")
    public <T>T getInstance(){
        Class<?> clazz = target.getClass();
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj =method.invoke(this.target,args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("代理开始");
    }

    private void after() {
        System.out.println("代理结束");
    }
}