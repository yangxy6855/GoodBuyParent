package com.java.service.impl;

import com.alibaba.fastjson.JSON;
import com.java.mapper.SecKillMapper;
import com.java.service.SecKillService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:55
 */
@Service
@Transactional(readOnly = false)
public class SecKillServiceImpl implements SecKillService{

    @Autowired
    private SecKillMapper secKillMapper;
    
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<Map<String, Object>> findUnStartProduct() {
        return secKillMapper.selectUnStartProduct();
    }

    @Override
    public void modifyUnStart2Starting() {
        secKillMapper.updateUnStart2Starting();
    }

    @Override
    public void modifyStarting2Finished() {
        secKillMapper.updateStarting2Finished();
    }

    @Override
    public Map<String, Object> findProductInfoBySeckillId(Long seckillId) {
        return secKillMapper.selectProductInfoBySeckillId(seckillId);
    }

    @Override
    public List<Long> findAllStartindProductId() {
        return secKillMapper.selectAllStartindProductId();
    }

    @Override
    public String findProductSecKillStatus(Long seckillId) {
        ValueOperations vop = redisTemplate.opsForValue();
        Object o = vop.get("seckill_product_status" + seckillId);
        if(o==null){//redis库中记录商品状态的记录被移除了
            return "2";//商品秒杀已经结束
        }
        return (String)o;
    }

    @Override
    public List<Long> selectAllFinishedProductId() {
        return secKillMapper.selectAllFinishedProductId();
    }

    @Override
    public void saveData2RabbitMQ(Long seckillId, String uName) {
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("seckillId",seckillId);
        dataMap.put("uName",uName);
        rabbitTemplate.convertAndSend("ex-order",null,dataMap);
        System.out.println("save 2 rabbitMQ success dataMap is "+JSON.toJSONString(dataMap));
    }

}
