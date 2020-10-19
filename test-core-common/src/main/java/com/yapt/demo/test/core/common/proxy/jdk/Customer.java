package com.yapt.demo.test.core.common.proxy.jdk;

import com.yapt.demo.test.core.common.proxy.Person;

/**
 * @author hurui
 * @version Id: Customer.java, v 0.1 2020/9/18 15:20 YaphetS Exp $$
 */
public class Customer implements Person {

    @Override
    public void findLove(String name) {
        System.out.println("我的名字叫:"+name);
        System.out.println("我要找个漂亮MM");
    }
}