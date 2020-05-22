package com.yapt.demo.test.core.web;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author hurui
 * @version Id: RateLimiter.java, v 0.1 2020/4/29 17:04 YaphetS Exp $$
 */
@Slf4j
public class RateLimiterTest extends BaseTest{


    @Test
    public void test(){
        /**
         * 创建一个限流器，设置每秒放置的令牌数：2个。速率是每秒可以2个的消息。
         * 返回的RateLimiter对象可以保证1秒内不会给超过2个令牌，并且是固定速率的放置。
         * 达到平滑输出的效果
         */
        RateLimiter r = RateLimiter.create(2);

        while (true)
        {
            /**
             * acquire()获取一个令牌，并且返回这个获取这个令牌所需要的时间。
             * 如果桶里没有令牌则等待，直到有令牌。
             * acquire(N)可以获取多个令牌。
             */
            System.out.println(r.acquire());
        }
    }
}