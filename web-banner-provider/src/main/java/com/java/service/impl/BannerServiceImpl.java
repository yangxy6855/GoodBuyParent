package com.java.service.impl;

import com.java.mapper.BannerMapper;
import com.java.service.BannserService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * date：15:54
 */
@Service
@Transactional(readOnly = false)
public class BannerServiceImpl implements BannserService{

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Map<String, Object>> findBanners() {
        try {
            ValueOperations vop = redisTemplate.opsForValue();
            Object v = vop.get("webBanners");
            if(v==null){//redis中不存在
                List<Map<String, Object>> bannerList = bannerMapper.selectBanners();
                vop.set("webBanners",bannerList);
                redisTemplate.expire("webBanners",5, TimeUnit.MINUTES);
                return bannerList;
            }else{//redis中存在
                return (List<Map<String, Object>>) v;
            }
        } catch (Exception e) {
            return bannerMapper.selectBanners();
        }
    }
}
