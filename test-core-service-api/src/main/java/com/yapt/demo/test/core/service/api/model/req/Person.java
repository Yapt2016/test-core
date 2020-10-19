package com.yapt.demo.test.core.service.api.model.req;

import lombok.Data;

import java.util.Date;

/**
 * @author hurui
 * @version Id: Person.java, v 0.1 2020/7/13 14:39 YaphetS Exp $$
 */
@Data
public class Person {

    /**
     * id
     */
    private long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 生日
     */
    private Date birthDay;


}