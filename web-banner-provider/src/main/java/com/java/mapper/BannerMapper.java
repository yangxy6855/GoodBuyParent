package com.java.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：15:52
 */
public interface BannerMapper {

    /**
     * 查询web_banners表中的轮播图信息
     * @return
     */
    @Select("SELECT * FROM web_banner order by sort asc")
    List<Map<String,Object>> selectBanners();

}
