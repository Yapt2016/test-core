package com.yapt.demo.test.core.common.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author hurui
 * @version Id: StringRedisTemplate.java, v 0.1 2020/1/24 15:21 YaphetS Exp $$
 */
@Component
public class StringRedisTemplateManager {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 新增
     *
     * @param key      key
     * @param obj      value
     * @param timeout  超时时间
     * @param timeUnit 超时时间类型自定义
     */
    public void set(final String key, final Object obj, final long timeout, TimeUnit timeUnit) {
        if (obj != null) {
            final String value = JSON.toJSONString(obj);
            stringRedisTemplate.opsForValue().set(key, value, timeout, timeUnit);
        }
    }

    /**
     * 查询
     *
     * @param key   key
     * @param clazz 类型
     * @param <T>   结果泛型
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if (Objects.isNull(value)) {
            return null;
        }
        return JSON.parseObject(value, clazz);
    }

    /**
     * 删除redis，可批量删除
     *
     * @param key key
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                stringRedisTemplate.delete(key[0]);
            } else {
                stringRedisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

}