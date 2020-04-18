package com.java.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * description：
 * author：丁鹏
 * date：11:13
 */
public class MongoDBUtil {

    /**
     * 根据传递的集合名，获取指定集合对象
     * @return
     */
    public static MongoDatabase getDB(String host,int port,String databaseName){
        //1、连接MongoDB(url、port)
        MongoClient mongoClient = new MongoClient(host,port);
        //2、指定连接的具体库(k8513)
        MongoDatabase db = mongoClient.getDatabase(databaseName);
        return db;
    }

}
