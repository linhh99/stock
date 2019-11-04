package com.cellthinking.stock.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置缓存失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time){
        if(time > 0){
            Boolean expire = redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return expire;
        }else {
            return false;
        }
    }

    /**
     * 获取过期时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire;
    }

    /**
     * 判断健是否存在
     * @param key
     * @return
     */
    public boolean existKey(String key){
        Boolean aBoolean = redisTemplate.hasKey(key);
        return aBoolean;
    }

    /**
     * 批量删除key
     * @param key
     */
    public void del(String... key){
        if (key.length > 0 && key != null){
            if (key.length == 1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public Object getObject(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 放入redis
     * @param key
     * @param object
     */
    public void set(String key,Object object){
        redisTemplate.opsForValue().set(key, object);
    }
















}
