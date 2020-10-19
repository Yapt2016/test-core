package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.manager.impl.CommonServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hurui
 * @version Id: commonTest.java, v 0.1 2020/10/15 14:17 YaphetS Exp $$
 */
@Slf4j
public class commonTest extends BaseTest{

    @Resource
    private CommonServiceManager commonServiceManager;

    @Test
    public void insert(){
        Map<String,String> map = new HashMap<>();
        map.put("sql","");
        commonServiceManager.commonOperate(map);
    }

    @Test
    public void query(){
        try{
            Map<String,String> map = new HashMap<>();
            map.put("sql","select * from t_user where `sex` = '1' and city_id = '2';");
            Object obj = commonServiceManager.commonOperate(map);
            log.info("查询结果,return:{}",obj);
        }catch (Exception e){
            log.error("操作异常,error:",e);
        }
    }

    @Test
    public void update(){
        Map<String,String> map = new HashMap<>();
        map.put("sql","");
        commonServiceManager.commonOperate(map);
    }

    @Test
    public void delete(){
        Map<String,String> map = new HashMap<>();
        map.put("sql","");
        commonServiceManager.commonOperate(map);
    }
}