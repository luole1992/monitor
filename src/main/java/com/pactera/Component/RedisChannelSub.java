package com.pactera.Component;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @Classname RedisChannelSub
 * @Author luole
 * @Date 2018/12/10 0010 16:08
 * @Description TODO
 * @Version 1.0
 **/
public class RedisChannelSub implements RedisMsg {
    @Override
    public void receiveMessage(String message) {
        //注意通道调用的方法名要和RedisConfig的listenerAdapter的MessageListenerAdapter参数2相同
        System.out.println("这是RedisChannelSub"+"-----"+message);
    }
}
