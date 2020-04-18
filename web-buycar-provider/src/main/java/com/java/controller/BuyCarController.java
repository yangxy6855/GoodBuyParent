package com.java.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.java.pojo.web.BuyCar;
import com.java.pojo.web.GoodItem;
import com.java.service.BuyCarService;
import com.java.utils.Base64Utils;
import com.java.utils.BuyCarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * description：
 * author：丁鹏
 * date：09:18
 */
@RestController//是@Controller+@ResponseBody注解的结合
@RequestMapping("/buycar")
public class BuyCarController {

    @Autowired
    private RedisTemplate redisTemplate;
    
    @Autowired
    private BuyCarService buyCarService;


    @RequestMapping("/login/{uName}")
    public String login(@PathVariable(name = "uName") String uName,HttpSession session){
        session.setAttribute("uName",uName);
        return "hello login successful";
    }

    /**
     * 将商品加入购物车
     * @param productNum
     * @param count
     * @return
     */
    @RequestMapping("/addGood2BuyCar")
    public Map<String,Object> addGood2BuyCar(String productNum,
                                             Integer count,
                                             HttpSession session,
                                             HttpServletRequest request,
                                             HttpServletResponse response){
        Cookie cookie = null;//定义全局的Cookie
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","0");//购物车添加成功
        try {
            BuyCar buyCar = null;
            Map<String, Object> cookieMap = BuyCarUtil.isCookieExistBuyCar(request);
            boolean flag = (boolean)cookieMap.get("flag");//cookie没有购物车，或者购物车中的商品为空
            String cookieValue = (String)cookieMap.get("cookieValue");//记录cookie中的value值
            //3、如果存在商品则添加至购物车
            if(flag){
                //取出Cookie中对应的加密后的购物车对象的json字符串
                //对加密的字符串进行解密，得到的是一个json字符串
                String jsonBuyCarStr = Base64Utils.getFromBASE64(cookieValue);
                //将json字符串还原成BuyCar对象
                buyCar = JSON.parseObject(jsonBuyCarStr,BuyCar.class);
                //判断购物车中是否存在指定的productNum的商品
                int goodItemIndex = buyCar.getGoodItemIndex(productNum);
                //将新添加的商品存放到购物车对象中去
                if(goodItemIndex==-1){//购物车中不存在指定编号的商品
                    GoodItem goodItem = new GoodItem(productNum,count);
                    buyCar.getGoodItemList().add(goodItem);
                }else{//购物车中存在指定编号的商品
                    //取出购物车中存在商品对应的原始数量
                    GoodItem oldGoodItem = buyCar.getGoodItemList().get(goodItemIndex);
                    int newCount = oldGoodItem.getCount()+count;
                    oldGoodItem.setCount(newCount);
                    buyCar.getGoodItemList().set(goodItemIndex,oldGoodItem);
                }
                //将购物车回写给浏览器端
            }else{
                //4、如果不存在则创建新的购物车，然后将购物车加入到cookie中去
                buyCar = new BuyCar();
                GoodItem goodItem = new GoodItem(productNum,count);
                buyCar.getGoodItemList().add(goodItem);
            }
            //判断用户是否登录
            //判断是否登录
            Object uName = session.getAttribute("uName");
            if(uName==null){//未登录
                //将购物车对象进行加密
                String jsonBuyCar = JSON.toJSONString(buyCar);
                //去掉json中的空格和换行符
                jsonBuyCar = jsonBuyCar.replaceAll("[\r\n]*","");
                String encryBuyCarStr = Base64Utils.getBASE64(jsonBuyCar);
                encryBuyCarStr = encryBuyCarStr.replaceAll("\r\n","");
                //将数据保存进cookie
                cookie = new Cookie("cookieBuyCar",encryBuyCarStr);
                cookie.setMaxAge(32*3600);
            }else{//登录
                //将购物车追加到redis中去---将cookie购物车与redis中的购物车合并
                //取redis中的购物车
                ValueOperations vop = redisTemplate.opsForValue();
                Object redisValue = vop.get(uName + "RedisBuyCar");
                if(redisValue==null){//redis中没有购物车
                    vop.set(uName + "RedisBuyCar",buyCar);
                    redisTemplate.expire(uName + "RedisBuyCar",180, TimeUnit.DAYS);
                }else{//redis存在购物车
                    //将cookie中的购物车与redis中的购物车合并
                    BuyCar redisBuyCar = (BuyCar)redisValue;
                    buyCar = buyCar.heBingBuyCar(redisBuyCar);
                    //将合并后的购物车存放到redis中去
                    vop.set(uName + "RedisBuyCar",buyCar);
                    redisTemplate.expire(uName + "RedisBuyCar",180, TimeUnit.DAYS);
                }
                //清空cookie
                cookie = new Cookie("cookieBuyCar","");
                cookie.setMaxAge(0);
            }
            //定义cookie的路径
            cookie.setPath("/buycar");
            //回写给浏览器客户端
            response.addCookie(cookie);
            //统计购物车中商品的种类
            resultMap.put("type",buyCar.getGoodItemList().size());
            //统计购物车中商品的总件数
            resultMap.put("num",buyCar.countGoodNum());
            //统计购物车中商品的总价格----三层
            resultMap.put("cost",9.99F);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status","1");//添加购物车失败
            return resultMap;
        }
    }

    /**
     * 从购物车中获取商品信息
     * @param uName
     * @return
     */
    @RequestMapping("/getGoodItemFromBuyCar")
    public List<Map<String,Object>> getGoodItemFromBuyCar(@RequestParam(name = "uName",required = false) String uName,
                                                HttpServletRequest request){
        try {
            BuyCar buyCar = null;
            //1、如果用户没有登录，则从cookie中获取
            if(uName==null || "".equals(uName.trim())){
                //2、判断cookie中的购物车是否为空
                Map<String, Object> cookieMap = BuyCarUtil.isCookieExistBuyCar(request);
                boolean flag = (boolean)cookieMap.get("flag");//cookie没有购物车，或者购物车中的商品为空
                String cookieValue = (String)cookieMap.get("cookieValue");//记录cookie中的value值
                if(!flag){
                    return null;
                }
                //3、将cookie中的据解密，还原成BuyCar类型对象
                String jsonBuyCarStr = Base64Utils.getFromBASE64(cookieValue);
                buyCar = JSON.parseObject(jsonBuyCarStr, BuyCar.class);
            }else{
                //2、如果用户登陆，则从redis中获取
                ValueOperations vop = redisTemplate.opsForValue();
                Object redisValue = vop.get(uName + "RedisBuyCar");
                if(redisValue==null){//redis中不存在购物车
                    return null;
                }
                //redis中存在购物车数据
                buyCar = (BuyCar)redisValue;
            }
            //取出buyCar中存放商品数据的LIst集合
            List<GoodItem> goodItemList = buyCar.getGoodItemList();
            //调用三层，通过productNum，查询此商品的购物车商品信息：price、title、imgUrl、href
            List<Map<String, Object>> resultList = new ArrayList<>();
            goodItemList.forEach(temp -> {
                String productNum = temp.getProductNum();
                Integer count = temp.getCount();
                Map<String, Object> productDetailMap = buyCarService.findProductDetailByProductNum(productNum);
                if (productDetailMap != null && productDetailMap.size() != 0) {
                    productDetailMap.put("count", count);
                    resultList.add(productDetailMap);
                }
            });
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

}
