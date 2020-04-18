package com.java.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:53
 */
public interface SecKillMapper {
    /**
     * 从秒杀表web_seckill中获取即将参与秒杀的所有商品信息
     * @return
     */
    @Select("SELECT * FROM web_seckill WHERE status='0' AND startTime>now()")
    List<Map<String,Object>> selectUnStartProduct();

    /**
     * 将秒杀状态由未开始(0)--->正在秒杀(1)
     * @return
     */
    @Update("UPDATE web_seckill SET status='1' WHERE startTime<=NOW() AND endTime>=now()\n" +
            "AND status='0'")
    int updateUnStart2Starting();

    /**
     * 将秒杀状态由正在秒杀(1)----->秒杀结束(2)
     * @return
     */
    @Update("UPDATE web_seckill SET status='2' WHERE endTime<NOW() AND status='1'")
    int updateStarting2Finished();

    /**
     * 根据秒杀id查看秒杀商品的详细信息
     * @param seckillId
     * @return
     */
    @Select("SELECT * FROM web_seckill WHERE id=#{arg0}")
    Map<String,Object> selectProductInfoBySeckillId(Long seckillId);

    /**
     * 查询web_seckill表中正则进行秒杀的所有商品的秒杀id
     * @return
     */
    @Select("SELECT id as seckillId FROM web_seckill WHERE startTime<=NOW() AND endTime>=now()\n" +
            "AND status='1'")
    List<Long> selectAllStartindProductId();

    /**
     * 查询web_seckill表中所有结束秒杀的商品秒杀id
     * @return
     */
    @Select("SELECT id as seckillId FROM web_seckill WHERE status='1'\n" +
            "and endTime<NOW()")
    List<Long> selectAllFinishedProductId();
}
