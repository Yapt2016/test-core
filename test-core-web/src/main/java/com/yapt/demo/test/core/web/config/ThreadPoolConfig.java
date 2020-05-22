package com.yapt.demo.test.core.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hurui
 * @version Id: ThreadPoolConfig.java, v 0.1 2020/5/22 11:03 YaphetS Exp $$
 */
@Slf4j
@Configuration
public class ThreadPoolConfig {

    @Bean
    ThreadPoolTaskExecutor taskExecutor() {
        log.info("ThreadPoolConfig.taskExecutor,开始加载ThreadPoolTaskExecutor配置");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setMaxPoolSize(100);
        executor.setKeepAliveSeconds(1000);
        executor.setQueueCapacity(10000000);
        executor.setThreadNamePrefix("TaskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}