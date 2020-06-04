package com.java.utils;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * description：订单工具类
 * author：丁鹏
 * date：16:13
 */
public class OrderUtil {

    private static final String[] digital = {"0","1","2","3","4","5","6","7","8","9"};

    /**
     * 动态生成16位数的订单编号
     * @param uName
     * @return
     */
    public static String generateOrderNum(String uName){
        try {
            if(uName==null || "".equals(uName.trim())){
                return null;
            }
            //使用MD5加密，将明文变成长度=16的字节数组
            String txt = UUID.randomUUID() + uName;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(txt.getBytes("UTF-8"));
            StringBuffer orderNum = new StringBuffer("");
            //循环bytes，总共循环16遍，每次从10进制中选取一个数组
            for(byte b : bytes){//-128---->127
                int temp = b;
                if(temp<0){
                    temp+=256;
                }
                int index = temp%10;
                orderNum.append(digital[index]);
            }
            return orderNum.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(OrderUtil.generateOrderNum("zhangsan"));
    }

}
