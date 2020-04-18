package com.java.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:12
 */
public interface BuyCarMapper {

    /**
     * 根据商品编号查询商品的基本信息
     * @param productNum
     * @return
     */
    @Select("select wpd.href,wpd.productNum,wpd.title,wpd.price,wpi.imgUrl from web_product_detail wpd INNER JOIN web_product_img wpi\n" +
            "on wpd.id=wpi.productId  WHERE wpd.productNum=#{arg0} group by wpd.id")
    Map<String,Object> selectProductDetailByProductNum(String productNum);

}
