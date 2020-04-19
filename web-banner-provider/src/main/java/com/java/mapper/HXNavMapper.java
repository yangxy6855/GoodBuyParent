package com.java.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * description：查询横向导航栏
 * author：丁鹏
 * date：13:58
 */
public interface HXNavMapper {

    /**
     * 查询横向导航栏
     * @return
     */
    @Select("SELECT * FROM web_menu where menuType='1' LIMIT 8")
    List<Map<String,Object>> selectHxMenus();

}
