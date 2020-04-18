package com.java.service.impl;

import com.java.mapper.BuyCarMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:15
 */
@Service
@Transactional(readOnly = false)
public class BuyCarServiceImpl implements com.java.service.BuyCarService {
    @Autowired
    private BuyCarMapper buyCarMapper;

    /**
     * 根据商品编号查询商品的基本信息
     * @param productNum
     * @return
     */
    @Override
    public Map<String,Object> findProductDetailByProductNum(String productNum){
        return buyCarMapper.selectProductDetailByProductNum(productNum);
    }

}
