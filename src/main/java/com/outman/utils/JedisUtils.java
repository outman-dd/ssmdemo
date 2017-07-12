package com.outman.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created with IntelliJ IDEA.
 * User: outman
 * Date: 2017/7/10
 * Time: 下午8:53
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class JedisUtils {

    private static final Logger logger = LoggerFactory.getLogger(JedisPool.class);

    private static JedisPool jedisPool;

    private static Jedis jedis;

    /**
     * 获取资源
     *
     * @return
     */
    public static Jedis getInstance() throws Exception {

        if (jedis == null) {
            synchronized (JedisUtils.class) {
                if (jedis == null) {
                    try {
                        jedis = jedisPool.getResource();
                        jedis.connect();
                        logger.debug("getResource:{}", jedis);
                    } catch (Exception e) {
                        logger.error("getResource:{}", e);
                        if (jedis != null)
                            jedis.close();
                        throw e;
                    }
                }
            }
        }
        return jedis;
    }

    /**
     * 用指定的key set数据用到redis缓存
     *
     * @param key
     * @param value
     */
    public static void putObject(String key, String value) {
        jedis.set(key, value);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
