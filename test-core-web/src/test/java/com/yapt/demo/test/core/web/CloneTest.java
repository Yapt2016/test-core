package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.service.api.model.req.CloneTestReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hurui
 * @version Id: CloneTest.java, v 0.1 2020/7/7 14:53 YaphetS Exp $$
 */
@Slf4j
public class CloneTest extends BaseTest{

    @Test
    public void test(){
        CloneTestReqDTO a = new CloneTestReqDTO();
        a.setName("菜虚鲲");
        a.setAge("18");
        List<String> list = new ArrayList<>();
        list.add("唱");
        list.add("跳");
        list.add("rap");
        a.setHobbies(list);
        log.info("原型对象:{}",a);
        CloneTestReqDTO b = a.clone();
        log.info("浅克隆对象:{}",b);
        CloneTestReqDTO c = a.deepClone();
        log.info("深克隆对象:{}",c);
        log.info("********************************************************************");


        c.getHobbies().add("篮球");
        log.info("原型对象:{}",a);
        log.info("修改之后的深克隆对象:{}",c);

        log.info("********************************************************************");

        b.getHobbies().add("足球");
        log.info("原型对象:{}",a);
        log.info("修改之后的浅克隆对象:{}",b);
    }
}