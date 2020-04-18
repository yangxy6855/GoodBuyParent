package com.java.service;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：16:41
 */
public interface ProductService {

    /**
     * 根据商品编号查询商品的详细信息，包括商品的图片信息
     * @param productNum
     * @return
     */
    Map<String,Object> findProductDetailInfo(String productNum);

    /**
     *查询数据库中所有商品的详细信息
     * @return
     */
    List<Map<String,Object>> findAllProductDetailInfo();


}
