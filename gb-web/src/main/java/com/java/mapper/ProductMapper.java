package com.java.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：16:37
 */
public interface ProductMapper {

    /**
     * 根据商品编号查询商品的详细信息
     * @param productNum
     * @return
     */
    @Select("select * from web_product_detail where productNum=#{arg0}")
    Map<String,Object> selectProductDetailInfoByProductNum(String productNum);

    /**
     * 查询某个商品的图片信息
     * @param productNum
     * @return
     */
    @Select("select imgUrl from web_product_img where productNum=#{arg0}")
    List<String> selectProductImgs(String productNum);

    /**
     * 查询所有商品的商品编号
     * @return
     */
    @Select("select productNum from web_product_detail")
    List<String> selectAllProductNum();

}
