package com.java.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：15:53
 */
public interface BannserService {

    /**
     * 查询web_banners表中的轮播图信息
     * @return
     */
    List<Map<String,Object>> findBanners();

}
