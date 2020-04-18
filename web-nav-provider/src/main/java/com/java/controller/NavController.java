package com.java.controller;

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
 * date：14:03
 */
@Controller
@RequestMapping("/nav")
public class NavController {

    @Autowired
    private HxNavService hxNavService;

    /**
     * 查询横向导航栏
     * @return
     */
    @RequestMapping("/getHxNavs")
    public @ResponseBody List<Map<String,Object>> getHxNavs(){
        return hxNavService.findHxMenus();
    }

}
