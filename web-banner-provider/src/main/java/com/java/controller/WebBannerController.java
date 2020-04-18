package com.java.controller;

import com.java.service.BannserService;
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

    /**
     * 获取数据库中的轮播图信息
     * @return
     */
    @RequestMapping("/getWebBanners")
    public @ResponseBody List<Map<String,Object>> getWebBanners(){
        return bannserService.findBanners();
    }

}
