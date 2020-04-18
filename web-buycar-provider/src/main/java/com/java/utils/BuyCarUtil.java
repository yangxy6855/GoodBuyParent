package com.java.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * description：购物车模块的公共代码
 * author：丁鹏
 * date：16:07
 */
public class BuyCarUtil {

    /**
     * 判断cookie中是否存在购物车
     * @param request HttpServletRequest对象
     * @return
     */
    public static Map<String,Object> isCookieExistBuyCar(HttpServletRequest request){
        //1、获取Cookie中的购物车:  cookieBuyCar=
        Cookie[] cookies = request.getCookies();
        //2、判断cookie中的购物车是否为空
        boolean flag = false;//cookie没有购物车，或者购物车中的商品为空
        String cookieValue = null;//记录cookie中的value值
        for(int i = 0;cookies!=null && cookies.length>=1 && i<cookies.length;i++){
            Cookie tempCookie = cookies[i];
            String cookieName = tempCookie.getName();
            //cookie中存在购物车
            if("cookieBuyCar".equals(cookieName)){
                //判断购物车中的商品是否真的存在
                flag = true;
                cookieValue = tempCookie.getValue();
                break;
            }
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("flag",flag);
        resultMap.put("cookieValue",cookieValue);
        return resultMap;
    }

}
