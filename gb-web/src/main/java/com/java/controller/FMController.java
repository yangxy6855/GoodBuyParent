package com.java.controller;

import com.java.service.ProductService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：10:43
 */
@Controller
@RequestMapping("/freemaker")
public class FMController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Configuration configuration;

    /**
     * 研究freemaker的语法
     * @return
     */
    @RequestMapping("/toFmDemo1Page")
    public ModelAndView toFmDemo1Page(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("title","联想电脑Y320");
        resultMap.put("subTitle","1折秒杀");
        resultMap.put("price",5999F);
        resultMap.put("flag",true);
        //图片地址
        List<String> imgUrlList = new ArrayList<String>();
        imgUrlList.add("http://192.168.25.133/group1/M00/00/05/wKgZhVzgwPGAangvAABD_zdjoXY679.jpg");
        imgUrlList.add("http://192.168.25.133/group1/M00/00/05/wKgZhVzgwTiAejSrAAA_FrDP7dQ569.jpg");
        imgUrlList.add("http://192.168.25.133/group1/M00/00/05/wKgZhVzgwVSAcsbZAAAsArZ94fE796.jpg");
        resultMap.put("imgUrlList",imgUrlList);
        ModelAndView mv = new ModelAndView("fmDemo1");
        mv.addAllObjects(resultMap);
        //mv.addObject("productMap",resultMap);
        return mv;
    }

    /**
     * 手动生成指定的商品详情静态化页面
     * @param productNum
     * @return
     */
    @RequestMapping("/generateProductHTMLByFTL/{productNum}")
    public @ResponseBody String generateProductHTMLByFTL(@PathVariable(name = "productNum") String productNum) throws Exception {
        //1、首先查询出商品的详细信息
        Map<String, Object> dataMap = productService.findProductDetailInfo(productNum);
        //2、获取Configuration，再获取代表模板引擎的对象(Template)
        Template template = configuration.getTemplate("Product.ftl");
        //3、通过模板引擎生成html文件，然后将html文件保存到指定的位置
        File file = new File("D:\\GoodBuy\\productDetail\\"+productNum+".html");
        FileWriter fw = new FileWriter(file);
        template.process(dataMap,fw);
        fw.close();
        return file.getPath();
    }

}
