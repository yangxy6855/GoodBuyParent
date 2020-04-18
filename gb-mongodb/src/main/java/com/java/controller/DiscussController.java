package com.java.controller;

import com.java.utils.MongoDBUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * description：
 * author：丁鹏
 * date：10:57
 */
@Controller
@RequestMapping("/discuss")
public class DiscussController {

    /**
     * 从MongoDB库中的discusses集合中获取指定的评论信息
     * @param productNum
     * @return
     */
    @RequestMapping("/getDiscuss/{productNum}")
    public @ResponseBody List<Document> getDiscuss(@PathVariable(name = "productNum") String productNum){
        MongoDatabase db = MongoDBUtil.getDB("127.0.0.1", 27017, "k8513");
        MongoCollection<Document> disCollection = db.getCollection("discusses");
        FindIterable<Document> documents = disCollection.find(Document.parse("{\"productNum\":\"" + productNum + "\" }"));
        List<Document> documentList = new ArrayList<>();
        documents.iterator().forEachRemaining(temp->{
            documentList.add(temp);
        });
        return documentList;
    }

}
