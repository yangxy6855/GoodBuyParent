package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.*;

/**
 * description：
 * author：丁鹏
 * date：16:43
 */
@Controller
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/login/{uName}/pwd")
    public String login(@PathVariable(name = "uName") String uName,
                        @PathVariable(name = "pwd")String pwd){
        //调用三层查询用户是否存在
        //如果用户登录成功则立马将cookie中的购物车与redis中的购物车合并
        //合并后，还用清空cookie中的购物车
        return null;
    }


    /**
     * 默认跳转到Index首页
     * @return
     */
    @RequestMapping("/")
    public String toIndexPage(Model model){
        //1、调用横向导航栏提供者获取数据
        List<Map<String,Object>> hxNavList = restTemplate.getForObject("http://webNavProvider/nav/getHxNavs", List.class);
        model.addAttribute("hxNavList",hxNavList);
        //2、调用轮播图提供者获取数据
        List<Map<String,Object>> bannerList = restTemplate.getForObject("http://webBannerProvider/banner/getWebBanners", List.class);
        model.addAttribute("bannerList",bannerList);
        //3、调用热门商品提供者获取数据
       List<Map<String,Object>> hotProductList = restTemplate.getForObject("http://webHotProvider/hot/getHotProducts", List.class);model.addAttribute("hotProductList",hotProductList);
        return "/pages/Index.jsp";
    }

}
