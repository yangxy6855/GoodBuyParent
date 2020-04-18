package com.java.service;

/**
 * description：订单
 * author：丁鹏
 * date：20:01
 */
public interface OrderService {

    /**
     * 添加订单
     * @param orderNo
     * @param uName
     * @param orderStatus
     * @param secId
     */
    void saveOrder(String orderNo, String uName, String orderStatus, Long secId);

}
