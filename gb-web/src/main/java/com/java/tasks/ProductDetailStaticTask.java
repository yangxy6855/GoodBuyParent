package com.java.tasks;

import com.java.service.ProductService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：11:20
 */
@Component
public class ProductDetailStaticTask {

    @Autowired
    private ProductService productService;

    @Autowired
    private Configuration configuration;
    /**
     * 每隔20s执行一次
     */
    @Scheduled(cron = "0/59 * * * * *")
    public void generateProductDetailHTMLPage(){
        List<Map<String, Object>> productDeteilList = productService.findAllProductDetailInfo();
        productDeteilList.forEach((Map<String, Object> temp) ->{
            try {
                //开始生成静态化页面
                Template template = configuration.getTemplate("Product.ftl");
                //获取商品编号
                String productNum = (String) temp.get("productNum");
                File checkFile = new File("/Users/yangxy/Pictures/GoodBuy/productDetail");
                if(!checkFile.exists()){
                    checkFile.mkdirs();
                }
                File file = new File("/Users/yangxy/Pictures/GoodBuy/productDetail/"+productNum+".html");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                template.process(temp,bw);
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
