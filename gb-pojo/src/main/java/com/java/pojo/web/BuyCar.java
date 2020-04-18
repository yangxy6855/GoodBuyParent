package com.java.pojo.web;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * description：购物车
 * author：丁鹏
 * date：09:35
 */
@Data
public class BuyCar implements Serializable{
    private static final long serialVersionUID = 4627898228482322342L;
    private List<GoodItem> goodItemList = new ArrayList<>();//商品

    /**
     * 判断指定编号的商品在购物车List集合中的下标位置
     * @param productNum
     * @return -1：指定编号的商品在购物车中不存在，其他均为存在
     */
    public int getGoodItemIndex(String productNum){
        List<GoodItem> goodItemList = this.getGoodItemList();
        //指定编号的商品在购物车中不存在
        if(goodItemList==null || goodItemList.size()==0 || productNum==null){
            return -1;
        }
        for(int i = 0;i<goodItemList.size();i++){
            GoodItem goodItem = goodItemList.get(i);
            //购物车对象的List集合中存在此编号的商品
            if(productNum.equals(goodItem.getProductNum())){
                return i;
            }
        }
        return -1;
    }

    /**
     * 统计购物车中商品件数的总数量
     * @return
     */
    public int countGoodNum(){
        List<GoodItem> goodItemList = this.goodItemList;
        if(goodItemList==null || goodItemList.size()==0){
            return 0;
        }
        int sum = 0;//记录总件数
        for (GoodItem goodItem : goodItemList){
            sum+=goodItem.getCount();
        }
        return sum;
    }

    /**
     * 合并两个购物车，返回一个大的购物车
     * @param buycar
     * @return
     */
    public BuyCar heBingBuyCar(BuyCar buycar){
        //取出第1个购物车中的List集合
        List<GoodItem> cookieBuyCarList = this.getGoodItemList();
        //取出第2个购物车中的List集合
        List<GoodItem> redisBuyCarList = buycar.getGoodItemList();
        //开始合并
        Map<Integer,Integer> xtIndexMap = new HashMap<>();//记录cookieBuyCarList集合与redisBuyCarList集合中数据相同部分的下标
        //存放两个集合不同的部分
        List<GoodItem> diffBuyCarList = new ArrayList<>();
        diffBuyCarList.addAll(redisBuyCarList);
        for (int i = 0;i<cookieBuyCarList.size();i++){//cookie购物车---->参考点
            for(int j=0;j<redisBuyCarList.size();j++){//redis购物车
                GoodItem cookieGoodItem = cookieBuyCarList.get(i);
                GoodItem redisGoodItem = redisBuyCarList.get(j);
                if(cookieGoodItem.getProductNum().equals(redisGoodItem.getProductNum())){
                    xtIndexMap.put(i,j);
                    diffBuyCarList.remove(redisGoodItem);
                }
            }
        }
        //开始合并数据
        xtIndexMap.forEach((k,v)->{
            //合并后的
            int totalCount = cookieBuyCarList.get(k).getCount()+redisBuyCarList.get(v).getCount();
            cookieBuyCarList.get(k).setCount(totalCount);
        });
        diffBuyCarList.addAll(cookieBuyCarList);
        BuyCar bigBuyCar = new BuyCar();
        bigBuyCar.setGoodItemList(diffBuyCarList);
        return bigBuyCar;
    }
}
