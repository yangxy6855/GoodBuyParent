package com.java.service.impl;

import com.java.mapper.ProductMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：16:40
 */
@Service
public class ProductServiceImpl implements com.java.service.ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Map<String, Object> findProductDetailInfo(String productNum) {
        //1、查询商品的基本详细信息
        Map<String, Object> productMap = productMapper.selectProductDetailInfoByProductNum(productNum);
        //2、查询此商品的图片信息
        List<String> imgUrlList = productMapper.selectProductImgs(productNum);
        //3、将基本信息与图片信息结果合并
        productMap.put("imgUrlList",imgUrlList);
        return productMap;
    }

    @Override
    public List<Map<String,Object>> findAllProductDetailInfo() {
        List<Map<String,Object>> productDetailList = new ArrayList<>();
        //1、获取所有商品的商品编号
        List<String> productNumList = productMapper.selectAllProductNum();
        //2、遍历封装了商品编号的List集合，
        productNumList.forEach(temp->{
            //3、通过商品编号查询某个商品的具体信息
            Map<String, Object> productMap = productMapper.selectProductDetailInfoByProductNum(temp);
            //4、查询商品的图片信息
            List<String> imgUrlList = productMapper.selectProductImgs(temp);
            productMap.put("imgUrlList",imgUrlList);
            //5、存放一个商品编号
            productMap.put("productNum",temp);
            productDetailList.add(productMap);
        });
        return productDetailList;
    }
}
