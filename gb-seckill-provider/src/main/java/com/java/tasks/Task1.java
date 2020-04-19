package com.java.tasks;

import com.java.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:57
 */
@Component
@Slf4j
public class Task1 {
    @Autowired
    private SecKillService secKillService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 定时扫描秒杀表，将即将参与秒杀的商品信息放入到redis中去
     */
    @Scheduled(cron = "0/30 * * * * *")
    public void getUnStartProduct2Redis(){
        //System.out.println("Task1.....getUnStartProduct2Redis()");
        try {
            log.info("Task1--getUnStartProduct2Redis()--start");
            //使用redis的帮助类
            ListOperations listVop =  redisTemplate.opsForList();
            ValueOperations vop = redisTemplate.opsForValue();
            //即将参与秒杀的所有商品
            List<Map<String, Object>> unStartProductList = secKillService.findUnStartProduct();
            for(int i = 0;unStartProductList!=null && unStartProductList.size()>=1 && i<unStartProductList.size();i++){
                Map<String, Object> unStartProductMap = unStartProductList.get(i);
                Long seckillId = (Long) unStartProductMap.get("id");
                Integer num = (Integer) unStartProductMap.get("num");
                //判断即将开始秒杀的商品是否已经进入redis中
                Long size = listVop.size("seckill_product_" + seckillId);
                if(0==size){
                    //往redis中单独存放商品的秒杀状态(0：未开始、1：已经开始、2结束)
                    vop.set("seckill_product_status"+seckillId,"0");
                    for(int j=0;j<num;j++){
                        listVop.leftPush("seckill_product_"+seckillId,seckillId);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Task1....getUnStartProduct2Redis()....发生错误了");
            e.printStackTrace();
        }
    }

    /**
     * 由未开始状态(0)----->正在进行(1)
     */
    @Scheduled(cron = "0/59 * * * * *")
    public void updateUnStart2Starting(){
        //System.out.println("Task1.....updateUnStart2Starting()");
        log.info("Task1--updateUnStart2Starting()--start");
        ValueOperations vop = redisTemplate.opsForValue();
        List<Long> seckillIdList = secKillService.findAllStartindProductId();
        for(int i=0;seckillIdList!=null && seckillIdList.size()>=1&& i<seckillIdList.size();i++){
            Long seckillId = seckillIdList.get(i);
            //找出那些商品正在进行秒杀
            vop.set("seckill_product_status"+seckillId,"1");
        }
        secKillService.modifyUnStart2Starting();
    }

    /**
     * 由正在进行(1)----->已经结束
     */
    @Scheduled(cron = "0/59 * * * * *")
    public void updateStarting2Finished(){
        log.info("Task1--updateStarting2Finished()--start");
        //System.out.println("Task1.....updateStarting2Finished");
        //当秒杀结束时，将redis中商品的状态信息移除掉
        ValueOperations vop = redisTemplate.opsForValue();
        List<Long> seckillIdList = secKillService.selectAllFinishedProductId();
        for(int i=0;seckillIdList!=null && seckillIdList.size()>=1&& i<seckillIdList.size();i++){
            Long seckillId = seckillIdList.get(i);
            //找出所有秒杀时间结束的商品状态
            redisTemplate.delete("seckill_product_status"+seckillId);
            //找出所有秒杀结束时，并且还没有卖完的商品
            redisTemplate.delete("seckill_product_" + seckillId);
        }
        //当秒杀结束时，将web_seckill表中商品状态由1--->2
        secKillService.modifyStarting2Finished();
    }

}
