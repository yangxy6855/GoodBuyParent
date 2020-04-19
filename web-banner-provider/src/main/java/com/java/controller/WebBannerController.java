package com.java.controller;

import com.java.service.BannserService;
import com.java.service.HotService;
import com.java.service.HxNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：15:55
 */
@Controller
@RequestMapping("/banner")
public class WebBannerController {

    @Autowired
    private BannserService bannserService;

    @Autowired
    private HxNavService hxNavService;


    @Autowired
    private HotService hotService;

    /**
     * 获取数据库中的轮播图信息
     * @return
     */
    @RequestMapping("/getWebBanners")
    public @ResponseBody List<Map<String,Object>> getWebBanners(){
        return bannserService.findBanners();
    }

    /**
     * 查询横向导航栏
     * @return
     */
    @RequestMapping("/getHxNavs")
    public @ResponseBody List<Map<String,Object>> getHxNavs(){
        return hxNavService.findHxMenus();
    }

    /**
     * 获取热门商品列表
     * @return
     */
    @RequestMapping("/getHotProducts")
    public @ResponseBody List<Map<String,Object>> getHotProducts(){
        return hotService.findProductList();
    }

}
