package com.pactera.Component;

/**
 * @Classname RedisPmpSub
 * @Author luole
 * @Date 2018/12/10 0010 16:10
 * @Description TODO
 * @Version 1.0
 **/
public class RedisPmpSub implements RedisMsg {
    @Override
    /**
     * 接收消息的方法
     * @param message 订阅消息
     */
    public void receiveMessage(String message) {
        //注意通道调用的方法名要和RedisConfig2的listenerAdapter的MessageListenerAdapter参数2相同
        System.out.println("这是RedisPmpSub-----"+message);
    }
}
