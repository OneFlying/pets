package com.guo.pets.plugin.cacheutil;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisFacotry {

    // 保证不被new
    private RedisFacotry() {}

    // 静态内部类
    private static class Holder{
        private static RedisFacotry INSTANCE = new RedisFacotry();
    }

    // 获取redis对象保证多线程环境下生成唯一对象
    public static RedisFacotry getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        int timeout = 300000;
        int maxRedirections = 6;

        // 连接池配置
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxWaitMillis(-1L);
        genericObjectPoolConfig.setMaxTotal(1000);
        genericObjectPoolConfig.setMinIdle(8);
        genericObjectPoolConfig.setMaxIdle(100);

        // 集群地址
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("192.168.110.133", 7000));
        hostAndPorts.add(new HostAndPort("192.168.110.133", 7001));
        hostAndPorts.add(new HostAndPort("192.168.110.133", 7002));
        hostAndPorts.add(new HostAndPort("192.168.110.134", 7003));
        hostAndPorts.add(new HostAndPort("192.168.110.134", 7004));
        hostAndPorts.add(new HostAndPort("192.168.110.134", 7005));


        JedisCluster jedisCluster = new JedisCluster(hostAndPorts,
                timeout,
                maxRedirections,
                genericObjectPoolConfig);

        String result = jedisCluster.get("key2");

        System.out.println(result);


    }
}
