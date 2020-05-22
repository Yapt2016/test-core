package com.yapt.demo.test.core.web.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author hurui
 * @version Id: StringRedisTemplateConfig.java, v 0.1 2020/1/24 15:28 YaphetS Exp $$
 */
@Slf4j
@Configuration
public class StringRedisTemplateConfig {

    /**
     * StringRedisTemplate 继承的是 RedisTemplate的泛型类，指定了String-String的泛型！故功能只专注于String类型！
     * 因此不推荐使用StringRedisTemplate，建议使用RedisTemplate
     *
     * @return
     */
    @Bean
    @SuppressWarnings("all")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
        log.info("StringRedisTemplateConfig.stringRedisTemplate,开始加载stringRedisTemplate配置");
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        //String序列化方式(只能处理string类型)
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //JDK序列化方式(序列化结果最长)
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        //JSON序列化
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //FastJson序列化
        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        //设置连接工厂
        stringRedisTemplate.setConnectionFactory(connectionFactory);
        //StringRedisTemplate的key和value默认都是String序列化，所以这里指不指定都无所谓
        stringRedisTemplate.setKeySerializer(stringRedisSerializer);
        stringRedisTemplate.setHashKeySerializer(stringRedisSerializer);
        //value使用FastJson序列化进行序列化
        stringRedisTemplate.setValueSerializer(genericFastJsonRedisSerializer);
        stringRedisTemplate.setHashValueSerializer(genericFastJsonRedisSerializer);
        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }
}