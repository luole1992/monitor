package com.pactera.controller;

import io.lettuce.core.dynamic.annotation.Command;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Classname RedisController
 * @Author luole
 * @Date 2018/12/10 0010 16:16
 * @Description TODO
 * @Version 1.0
 **/
@EnableScheduling
@Component
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        stringRedisTemplate.convertAndSend("pmp", String.valueOf(Math.random()));
        stringRedisTemplate.convertAndSend("channel", String.valueOf(Math.random()));
    }
}
