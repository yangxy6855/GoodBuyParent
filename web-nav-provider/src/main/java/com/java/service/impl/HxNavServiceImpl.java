package com.java.service.impl;

import com.java.mapper.HXNavMapper;
import com.java.service.HxNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * description：
 * author：丁鹏
 * date：14:02
 */
@Service
@Transactional(readOnly = false)
public class HxNavServiceImpl implements HxNavService{

    @Autowired
    private HXNavMapper hxNavMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Map<String, Object>> findHxMenus() {
        try {
            //根据redisTemplate对象获取操作Redis的String工具类
            ValueOperations vop = redisTemplate.opsForValue();
            //1、首先查询redis中是否存在key=hxNavKey的数据
            Object value = vop.get("hxNavKey");
            //2、如果redis中存在，则取出并且返回
            if(value!=null){
                return (List<Map<String, Object>>) value;
            }else{
                //3、如果Redis中没有数据，首先从mysql中查询，然后将查询出的结果存放到redis中去，然后返回数据
                List<Map<String, Object>> navList = hxNavMapper.selectHxMenus();
                vop.set("hxNavKey",navList);
                //设置定时时间
                redisTemplate.expire("hxNavKey",5, TimeUnit.MINUTES);
                return navList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return hxNavMapper.selectHxMenus();
        }
    }
}
