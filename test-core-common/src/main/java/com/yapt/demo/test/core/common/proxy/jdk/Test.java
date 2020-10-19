package com.yapt.demo.test.core.common.proxy.jdk;

import com.yapt.demo.test.core.common.proxy.Person;

/**
 * @author hurui
 * @version Id: Test.java, v 0.1 2020/9/18 15:27 YaphetS Exp $$
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {

        JDKPersonProxy jdkProxy = new JDKPersonProxy();

        Person customer = jdkProxy.getInstance(new Customer());

        customer.findLove("zhaosi");

        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // jdk动态代理测试
        Person subject = new JDKObjectProxy(new Customer()).getInstance();
        subject.findLove("Rick");
    }
}