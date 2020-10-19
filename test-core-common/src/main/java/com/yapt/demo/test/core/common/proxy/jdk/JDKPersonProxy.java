package com.yapt.demo.test.core.common.proxy.jdk;

import com.yapt.demo.test.core.common.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hurui
 * @version Id: JDKProxy.java, v 0.1 2020/9/18 15:22 YaphetS Exp $$
 */
public class JDKPersonProxy implements InvocationHandler {

    private Person target;


    public Person getInstance(Person target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return (Person)Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
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