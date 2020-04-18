package com.java.service.impl;

import com.java.mapper.OrderMapper;
import com.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description：
 * author：丁鹏
 * date：20:02
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void saveOrder(String orderNo, String uName, String orderStatus, Long secId) {
        orderMapper.insertOrder(orderNo,uName,orderStatus,secId);
    }
}
