package com.java.controller;

import com.java.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：16:17
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private SecKillService secKillService;
    
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 秒杀
     * @param seckillId
     * @param uName
     * @return
     */
    /*@RequestMapping("/joinSeckillProduct/{seckillId}/{uName}")
    public Map<String,Object> joinSeckillProduct(@PathVariable(name = "seckillId") Long seckillId,
                                                 @PathVariable(name="uName") String uName){*/
    @RequestMapping("/joinSeckillProduct")
    public Map<String,Object> joinSeckillProduct(Long seckillId,String uName){
        //System.out.println(seckillId+"------------------------"+uName);
        //封装抢购的最终结果
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","0");//抢购成功
        try {
            //判断用户是否登录
            if(uName==null || "".equals(uName.trim())){
                resultMap.put("status","1");//秒杀失败
                resultMap.put("msg","您还未登录");
                return resultMap;
            }
            //判断商品的状态，查看秒杀是否开始
            String status = secKillService.findProductSecKillStatus(seckillId);
            if("0".equals(status)){
                resultMap.put("status","1");//秒杀失败
                resultMap.put("msg","秒杀还未开始，请等待");
                return resultMap;
            }
            if("2".equals(status)){
                resultMap.put("status","1");//秒杀失败
                resultMap.put("msg","秒杀已经结束了，下次再来吧");
                return resultMap;
            }
            //可以秒杀了
            ListOperations listVop = redisTemplate.opsForList();
            //从redis中的List集合中移除一个商品
            Object value = listVop.leftPop("seckill_product_" + seckillId);
            if(value==null){
                resultMap.put("status","1");//秒杀失败
                resultMap.put("msg","此商品已经被抢购一空了，下次再来吧");
                return resultMap;
            }
            //秒杀名额还存在
            //判断此用户是否重复抢购
            SetOperations setVop = redisTemplate.opsForSet();
            Boolean flag = setVop.isMember("seckill_users_" + seckillId, uName);
            if(flag){//此用户已经抢购过商品
                resultMap.put("status","1");
                resultMap.put("msg","秒杀名额每人只有一个，不可重复抢购");
                //往redis的List集合中添加一个商品秒杀id
                listVop.leftPush("seckill_product_" + seckillId,seckillId);
                return resultMap;
            }
            //此用户完全满足抢购要求
            setVop.add("seckill_users_" + seckillId,uName);
            //往RabbitMQ中指定的消息队列中添加数据'
            secKillService.saveData2RabbitMQ(seckillId,uName);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status","1");//秒杀失败
            resultMap.put("msg","当前秒杀人员太多，系统崩溃了，下次再来吧");
            return resultMap;
        }
    }

}
