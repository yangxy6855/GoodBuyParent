package com.java.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * description：
 * author：丁鹏
 * date：19:58
 */
public interface OrderMapper {

    /**
     * 添加订单信息
     * @param orderNo
     * @param uName
     * @param orderStatus
     * @param secId
     * @return
     */
    @Insert("INSERT INTO web_order VALUES(null,#{arg0},#{arg1},#{arg2},#{arg3})")
    int insertOrder(String orderNo, String uName, String orderStatus, Long secId);

}
