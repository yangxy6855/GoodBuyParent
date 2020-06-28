package com.java.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private JedisCluster jedisPool;

    /**
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String get(String key) {
        String value = null;
        try {
            value= jedisPool.get(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return value;
    }

    public String set(String key, String value) {
        try {
            return jedisPool.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "0";
        }
    }

    /**
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String leftPop(String key) {
        String value = null;
        try {
            value= jedisPool.lpop(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return value;
    }

    /**
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public void leftPush(String key,String name) {

        try {
             jedisPool.lpush(key, name);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public void sadd(String key,String name) {
        try {
           jedisPool.sadd(key, name);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    /**
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public Long llen(String key) {
        Long result=0L;
        try {
            result = jedisPool.llen(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }





    /**
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public Boolean isMember(String key,String member) {
        Boolean value = null;
        try {
            value = jedisPool.sismember(key, member);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return value;
    }


    /**
     * <p>
     * 删除指定的key,也可以传入一个包含key的数组
     * </p>
     *
     * @param keys 一个key 也可以使 string 数组
     * @return 返回删除成功的个数
     */
    public Long del(String... keys) {
        try {
            return jedisPool.del(keys);
        } catch (Exception e) {

            log.error(e.getMessage());
            return 0L;
        }
    }
    /**
     * <p>
     * 删除指定的key,也可以传入一个包含key的数组
     * </p>
     * @param indexdb 选择redis库 0-15
     * @param keys 一个key 也可以使 string 数组
     * @return 返回删除成功的个数
     */
    public Long del(int indexdb,String... keys) {
        try {
            return jedisPool.del(keys);
        } catch (Exception e) {

            log.error(e.getMessage());
            return 0L;
        }
    }
    /**
     * <p>
     * 删除指定的key,也可以传入一个包含key的数组
     * </p>
     * @param indexdb 选择redis库 0-15
     * @param keys 一个key 也可以使 string 数组
     * @return 返回删除成功的个数
     */
    public Long del(int indexdb,byte[]... keys) {
        try {
            jedisPool.select(indexdb);
            return jedisPool.del(keys);
        } catch (Exception e) {

            log.error(e.getMessage());
            return 0L;
        }
    }
    /**
     * <p>
     * 通过key向指定的value值追加值
     * </p>
     *
     * @param key
     * @param str
     * @return 成功返回 添加后value的长度 失败 返回 添加的 value 的长度 异常返回0L
     */
    public Long append(String key, String str) {
        Long res;
        try {
            res = jedisPool.append(key, str);
        } catch (Exception e) {

            log.error(e.getMessage());
            return 0L;
        }
        return res;
    }

    /**
     * <p>
     * 判断key是否存在
     * </p>
     *
     * @param key
     * @return true OR false
     */
    public Boolean exists(String key) {
         
        try {
            return  jedisPool.exists(key);
        } catch (Exception e) {

            log.error(e.getMessage());
            return false;
        }
    }



    /**
     * <p>
     * 为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除。
     * </p>
     *
     * @param key
     * @param value
     *            过期时间，单位：秒
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public Long expire(String key, int value, int indexdb) {
         
        try {
            return  jedisPool.expire(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0L;
        }
    }

    /**
     * <p>
     * 以秒为单位，返回给定 key 的剩余生存时间
     * </p>
     *
     * @param key
     * @return 当 key 不存在时，返回 -2 。当 key 存在但没有设置剩余生存时间时，返回 -1 。否则，以秒为单位，返回 key
     *         的剩余生存时间。 发生异常 返回 0
     */
    public Long ttl(String key,int indexdb) {
         
        try {
            return  jedisPool.ttl(key);
        } catch (Exception e) {

            log.error(e.getMessage());
            return 0L;
        }
    }



    /**
     * <p>
     * 新增key,并将 key 的生存时间 (以秒为单位)
     * </p>
     *
     * @param key
     * @param seconds
     *            生存时间 单位：秒
     * @param value
     * @return 设置成功时返回 OK 。当 seconds 参数不合法时，返回一个错误。
     */
    public String setex(String key, int seconds, String value) {
         
        try {
            return  jedisPool.setex(key, seconds, value);
        } catch (Exception e) {

            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * <p>
     * 设置key value,如果key已经存在则返回0,nx==> not exist
     * </p>
     *
     * @param key
     * @param value
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public Long setnx(String key, String value) {
        try {
            return  jedisPool.setnx(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0L;
        }
    }

    /**
     * <p>
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
     * </p>
     * <p>
     * 当 key 存在但不是字符串类型时，返回一个错误。
     * </p>
     *
     * @param key
     * @param value
     * @return 返回给定 key 的旧值。当 key 没有旧值时，也即是， key 不存在时，返回 nil
     */
    public String getSet(String key, String value) {
         
        try {
            return  jedisPool.getSet(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * <p>
     * 设置key value并制定这个键值的有效期
     * </p>
     *
     * @param key
     * @param value
     * @param seconds
     *            单位:秒
     * @return 成功返回OK 失败和异常返回null
     */
    public String setex(String key, String value, int seconds) {
         
        String res = null;
        try {
            res =  jedisPool.setex(key, seconds, value);
        } catch (Exception e) {

            log.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>
     * 通过key 和offset 从指定的位置开始将原先value替换
     * </p>
     * <p>
     * 下标从0开始,offset表示从offset下标开始替换
     * </p>
     * <p>
     * 如果替换的字符串长度过小则会这样
     * </p>
     * <p>
     * example:
     * </p>
     * <p>
     * value : bigsea@zto.cn
     * </p>
     * <p>
     * str : abc
     * </p>
     * <P>
     * 从下标7开始替换 则结果为
     * </p>
     * <p>
     * RES : bigsea.abc.cn
     * </p>
     *
     * @param key
     * @param str
     * @param offset
     *            下标位置
     * @return 返回替换后 value 的长度
     */
    public Long setrange(String key, String str, int offset) {
         
        try {
            return  jedisPool.setrange(key, offset, str);
        } catch (Exception e) {

            log.error(e.getMessage());
            return 0L;
        }
    }


}