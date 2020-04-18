package com.java.controller;

import com.yuqing.common.FastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：14:04
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    /**
     * 文件上传接口
     * @param uploadFile
     * @return
     */
    @RequestMapping("/uploadFile")
    public @ResponseBody Map<String,Object> uploadFile(MultipartFile uploadFile){
        //1、创建一个初始的Map集合，用来封装最终的上传结果
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","0");//上传成功
        try {
            //2、创建一个FastDFS文件上传的工具类对象：FastDFSClient
            FastDFSClient client = new FastDFSClient("classpath:resources/fdfs_client.conf");
            //3、上传文件，接收文件上传的路径
            //basePath="group1/M00/00/04/wKgZhVxozjWACYeZAACmK0sntbI152.jpg"
            //4、获取文件的后缀名
            //originalFilename:1.jpg、2.png、a.b.c.jpg
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String basePath = client.uploadFile(uploadFile.getBytes(), extName);
            //往resultMap集合中封装图片上传的地址
            resultMap.put("url","http://192.168.25.133/"+basePath);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status","1");//上传失败
            return resultMap;
        }
    }

}
