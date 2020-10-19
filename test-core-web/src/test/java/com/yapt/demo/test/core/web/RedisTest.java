package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.common.redis.RedisTemplateManager;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author hurui
 * @version Id: RedisTest.java, v 0.1 2020/7/15 14:37 YaphetS Exp $$
 */
public class RedisTest extends BaseTest{

    @Resource
    private RedisTemplateManager redis;

    @Test
    public void set(){
        String key = "test";
        String value = "菜虚鲲";
        long timeout = 1L;
        redis.set(key,value,timeout, TimeUnit.DAYS);
        System.out.println("新增成功");
    }

    @Test
    public void get(){
        String key = "BloomFilterTest";
        String value = redis.get(key);
        System.out.println("查询成功:"+value);
    }

    @Test
    public void del(){
        String key = "test";
        redis.del(key);
        System.out.println("删除成功");
    }
}