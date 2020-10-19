package com.yapt.demo.test.core.service.api.model.req;

import lombok.Data;

/**
 * @author hurui
 * @version Id: Student.java, v 0.1 2020/7/7 15:50 YaphetS Exp $$
 */
@Data
public class Student {

    public Student(){
        System.out.println("调用了【public】无参构造器");
    }

    protected Student(String name){
        System.out.println("调用了【protected】参构造器");
        this.name = name;
    }

    Student(String name,int age){
        System.out.println("调用了【default】参构造器");
        this.name = name;
        this.age = age;
    }

    public Student(String name,int age,char sex){
        System.out.println("调用了【public】多参构造器");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private Student(String name,int age,char sex,String phone){
        System.out.println("调用了【private】参构造器");
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }

    /**
     * 姓名
     */
    public String name;

    /**
     * 年龄
     */
    protected Integer age;

    /**
     * 性别
     */
    char sex;

    /**
     * 手机号
     */
    private String phone;


    public void sleep(String name){
        System.out.println(name+"调用了sleep方法");
    }

    protected void play(){
        System.out.println("调用了play方法");
    }

    void eat(){
        System.out.println("调用了eat方法");
    }

    private void work(String name){
        System.out.println(name+"调用了work方法");
    }

    public static void main(String[] args) {
        System.out.println("调用了main方法");
    }

}