package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.service.api.model.req.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hurui
 * @version Id: ListTest.java, v 0.1 2020/7/9 15:44 YaphetS Exp $$
 */
@Slf4j
public class ListTest extends BaseTest{

    private static List<Person> list = new ArrayList<>();

    public static Date format(String time){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(time);
        }catch (Exception e){
            return null;
        }
    }

    static {
        Person p1 = new Person();
        p1.setId(1L);
        p1.setName("小胡");
        p1.setAge(20);
        p1.setBirthDay(format("2000-01-30"));
        list.add(p1);
        Person p2 = new Person();
        p2.setId(1L);
        p2.setName("小张");
        p2.setAge(25);
        p2.setBirthDay(format("1995-11-30"));
        list.add(p2);
        Person p3 = new Person();
        p3.setId(1L);
        p3.setName("琪琪");
        p3.setAge(18);
        p3.setBirthDay(format("2002-10-30"));
        list.add(p3);
        Person p4 = new Person();
        p4.setId(1L);
        p4.setName("静静");
        p4.setAge(18);
        p4.setBirthDay(format("2002-08-30"));
        list.add(p4);
        Person p5 = new Person();
        p5.setId(1L);
        p5.setName("哈哈");
        p5.setAge(23);
        p5.setBirthDay(format("1997-12-30"));
        list.add(p5);
    }

    /**
     * 按年龄分组
     */
    @Test
    public void groupingBy(){
        Map<Integer,List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(map);
    }

    /**
     * 按年龄排序
     */
    @Test
    public void comparing(){
        List<Person> result = list.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(result);
    }

    /**
     * 先按年龄排序,相同的再按生日排序
     */
    @Test
    public void thenComparing(){
        List<Person> result = list.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getBirthDay)).collect(Collectors.toList());
        System.out.println(result);
    }

    /**
     * 匹配所有不符合给定规则的数据并剔除
     */
    @Test
    public void noneMatch(){
        String[] strings = new String[]{"小胡","哈哈","小张"};
        List<String> array = Arrays.asList(strings);
        list.removeIf(item1 -> array.stream().noneMatch(item2 -> item2.equals(item1.getName())));
        System.out.println(list);
    }

    /**
     * 匹配所有符合给定规则的数据并剔除
     */
    @Test
    public void anyMatch(){
        String[] strings = new String[]{"小胡","琪琪","静静"};
        List<String> array = Arrays.asList(strings);
        list.removeIf(item1 -> array.stream().anyMatch(item2 -> item2.equals(item1.getName())));
        System.out.println(list);
    }

    /**
     * 匹配所有符合给定规则的数据并剔除
     */
    @Test
    public void findFirst(){
        Person person = new Person();
        Optional<Person> optional = list.stream().filter(item -> 18 == item.getAge()).findFirst();
        person = optional.orElse(person);
        System.out.println(person);
    }

    /**
     * 匹配所有符合给定规则的数据并剔除
     */
    @Test
    public void findAny(){
        Person person = new Person();
        Optional<Person> optional = list.stream().filter(item -> 18 == item.getAge()).findAny();
        person = optional.orElse(person);
        System.out.println(person);
    }
}