package com.java.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:02
 */
public interface HxNavService {

    /**
     * 查询横向导航栏
     * @return
     */
    List<Map<String,Object>> findHxMenus();

}
