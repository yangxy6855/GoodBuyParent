package com.java.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
@Slf4j
public class RedisConfig {

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean  blockWhenExhausted;

    @Bean
    public JedisCluster jedisCluster()  throws Exception{
        log.info("JedisCluster注入成功！！");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,true阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        Set<HostAndPort> set = new HashSet();
        HostAndPort hostAndPort = new HostAndPort("106.53.245.224", 7001);
        set.add(hostAndPort);
        HostAndPort hostAndPort2 = new HostAndPort("106.53.245.224", 7002);
        set.add(hostAndPort2);
        HostAndPort hostAndPort3 = new HostAndPort("106.53.245.224", 7003);
        set.add(hostAndPort3);
        HostAndPort hostAndPort4 = new HostAndPort("129.28.156.82", 7004);
        set.add(hostAndPort4);
        HostAndPort hostAndPort5 = new HostAndPort("129.28.156.82", 7005);
        set.add(hostAndPort5);
        HostAndPort hostAndPort6 = new HostAndPort("129.28.156.82", 7006);
        set.add(hostAndPort6);
        JedisCluster jedisCluster = new JedisCluster(set,2000,2000,3,password,jedisPoolConfig);
        return jedisCluster;
    }


}