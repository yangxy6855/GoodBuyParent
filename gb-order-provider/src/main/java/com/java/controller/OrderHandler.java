package com.java.controller;

import com.java.service.OrderService;
import com.java.utils.OrderUtil;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * description：
 * author：丁鹏
 * date：11:42
 */
@Component
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    //指定连接的交换机与队列
    @RabbitListener(bindings = @QueueBinding(
            value= @Queue(value = "queue-order"),
            exchange = @Exchange(name = "ex-order",type = "fanout")
    ))
    //此方法自动执行
    @RabbitHandler
    public void handOrder(@Payload Map<String,Object> dataMap,
                          @Headers Map<String,Object> headers,
                          Channel channel){
        try {
            //1、安全监测
            Thread.sleep(3000);
            //2、接收RabbitMQ中的数据
            Long seckillId = (Long) dataMap.get("seckillId");
            String uName = (String) dataMap.get("uName");
            System.out.println(seckillId+"----------"+uName);
            //3、生成订单编号
            String orderNo = OrderUtil.generateOrderNum(uName);
            //4、将订单信息插入到数据库表web_order中去
            orderService.saveOrder(orderNo,uName,"0",seckillId);
            //5、手动确认订单处理完成
            long endTag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(endTag,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
