package com.guo.pets.plugin.cacheutil;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * redis链接单例工具类
 * @author guolejian
 */
public class RedisUtil {

    private RedisFacotry redisFacotry = RedisFacotry.getInstance();
    /**
     * 静态内部类
     */
    private static class Holder {
        private static RedisUtil INSTANCE = new RedisUtil();
    }

    /**
     * 保证不被new
     */
    private RedisUtil() {}

    /**
     * 获取单例对象
     * @return
     */
    public static RedisUtil getInstance() {
        return Holder.INSTANCE;
    }

}
