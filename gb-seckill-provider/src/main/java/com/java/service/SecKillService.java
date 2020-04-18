package com.java.service;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:55
 */
public interface SecKillService {

    /**
     * 从秒杀表web_seckill中获取即将参与秒杀的所有商品信息
     * @return
     */
    List<Map<String,Object>> findUnStartProduct();

    /**
     * 将秒杀状态由未开始(0)--->正在秒杀(1)
     * @return
     */
    void modifyUnStart2Starting();

    /**
     * 将秒杀状态由正在秒杀(1)----->秒杀结束(2)
     * @return
     */
    void modifyStarting2Finished();

    /**
     * 根据秒杀id查看秒杀商品的详细信息
     * @param seckillId
     * @return
     */
    Map<String,Object> findProductInfoBySeckillId(Long seckillId);

    /**
     * 查询web_seckill表中正则进行秒杀的所有商品的秒杀id
     * @return
     */
    List<Long> findAllStartindProductId();

    /**
     * 根据秒杀id查看秒杀商品的状态
     * @param seckillId
     * @return
     */
    String findProductSecKillStatus(Long seckillId);

    /**
     * 查询所有结束秒杀的商品秒杀id
     * @return
     */
    List<Long> selectAllFinishedProductId();

    /**
     * 秒杀后将数据存放到RabbitMQ中去
     * @param seckillId
     * @param uName
     */
    void saveData2RabbitMQ(Long seckillId,String uName);

}
