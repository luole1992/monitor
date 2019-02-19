package com.pactera.config;

        import com.pactera.Component.RedisChannelSub;
        import com.pactera.Component.RedisMsg;
        import com.pactera.Component.RedisPmpSub;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.cache.annotation.EnableCaching;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Scope;
        import org.springframework.data.redis.connection.RedisConnectionFactory;
        import org.springframework.data.redis.listener.PatternTopic;
        import org.springframework.data.redis.listener.RedisMessageListenerContainer;
        import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
        import redis.clients.jedis.HostAndPort;
        import redis.clients.jedis.JedisCluster;

        import java.util.HashSet;
        import java.util.Set;

/**
 * @Classname RedisConfig
 * @Author luole
 * @Date 2018/12/10 0010 15:46
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
@EnableCaching
public class RedisConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String hosts;

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //订阅一个pmp和一个channel的通道，多通道
        container.addMessageListener(listenerAdapter(new RedisPmpSub()),new PatternTopic("pmp"));
        container.addMessageListener(listenerAdapter(new RedisChannelSub()),new PatternTopic("channel"));
        //container可以配置多个messageListem
        return container;
    }

    @Bean()
    @Scope("prototype")
    public MessageListenerAdapter listenerAdapter(RedisMsg redisMsg){
        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        //也有好几个重载方法，这边默认调用处理器的方法 叫handleMessage 可以自己到源码里面看
        return new MessageListenerAdapter(redisMsg,"receiveMessage");//注意2个通道调用的方法都要为receiveMessage
    }

    public JedisCluster redisCluster(){
        try {
            Set<HostAndPort> nodes = new HashSet<>();
            String[] hostAttay = hosts.split(",");
            for(String host : hostAttay){
                String[] ipAndPost=host.split(":");
                nodes.add(new HostAndPort(ipAndPost[0],Integer.parseInt(ipAndPost[1])));
            }
            JedisCluster jedisCluster = new JedisCluster(nodes);
            return jedisCluster;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
