package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.common.redis.BloomFilterHelper;
import com.yapt.demo.test.core.common.redis.RedisTemplateManager;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author hurui
 * @version Id: RedisBoolomFilterTest.java, v 0.1 2020/7/15 14:37 YaphetS Exp $$
 */
public class RedisBloomFilterTest extends BaseTest{

    @Resource
    private RedisTemplateManager redis;

    @Resource
    private BloomFilterHelper bloomFilterHelper;

    @Test
    public void add(){
        String key = "BloomFilterTest";
        String value = "123";
        redis.addByBloomFilter(bloomFilterHelper,key,value);
        System.out.println("新增成功");
    }

    @Test
    public void exist(){
        String key = "BloomFilterTest";
        String value = "123";
        boolean flag = redis.includeByBloomFilter(bloomFilterHelper,key,value);
        System.out.println("判断结果:"+flag);
    }
}