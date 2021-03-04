package com.fh.tuils;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.TimeUnit;

//redis的工具类
public class RedisUtils {
    //某某池对象
    private static JedisPool jedisPool;

    //执行一次
    static {
        // 某某池  最大  最小  初始化大小  空闲时间
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMinIdle(2);
        poolConfig.setMaxIdle(5);
        //初始化连接池对象
        jedisPool=new JedisPool(poolConfig,"192.168.233.129",6379,0);
    }

    public static String get(String key){
        Jedis resource = jedisPool.getResource();
        String value = resource.get(key);
        jedisPool.returnResource(resource);
        return value;
    }

    public static String set(String key,Object data){
        String s = JSONObject.toJSONString(data);
        Jedis resource = jedisPool.getResource();
        String set = resource.set(key, s);
        return set;
    }
    public static String set(String key,String data){
        Jedis resource = jedisPool.getResource();
        String set = resource.set(key,data);
        return set;
    }


}
