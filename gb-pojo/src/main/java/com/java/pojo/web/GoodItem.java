package com.java.pojo.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description：商品类
 * author：丁鹏
 * date：09:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodItem implements Serializable{

    private static final long serialVersionUID = -3733805636368909595L;
    private String productNum;//商品编号
    private Integer count;//商品数量

}
