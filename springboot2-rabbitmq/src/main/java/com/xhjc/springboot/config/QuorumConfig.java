package com.xhjc.springboot.config;

import com.xhjc.springboot.util.MyConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：
 * @desc 声明一个Quorum队列
 */
@Configuration
public class QuorumConfig {
    @Bean
    public Queue quorumQueue() {
        Map<String,Object> params = new HashMap<>();
        params.put("x-queue-type","quorum");

        return new Queue(MyConstants.QUEUE_QUORUM,true,false,false,params);
    }
}
