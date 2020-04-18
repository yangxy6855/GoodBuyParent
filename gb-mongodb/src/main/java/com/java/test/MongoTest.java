package com.java.test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * description：
 * author：丁鹏
 * date：11:26
 */
public class MongoTest {
    private MongoClient mongoClient = null;
    private MongoCollection<Document> userCollection = null;

    @Before
    public void init(){
        //1、连接MongoDB(url、port)
        mongoClient = new MongoClient("127.0.0.1",27017);
        //2、指定连接的具体库(k8513)
        MongoDatabase db = mongoClient.getDatabase("k8513");
        //3、指定操作的具体集合(users)
        userCollection = db.getCollection("users");
    }

    /**
     * 往k8513库中的users集合中插入一条数据
     */
    @Test
    public void insertOne(){
        //4、执行mongodb操作
        //Document的父类型是：Map、BSON
        //将数据封装成Document的第1种方式
        Document doc = new Document();
        doc.append("uName","王二麻子");
        doc.append("age",18);
        //将数据封装成Document的第2种方式
        Document doc2 = Document.parse("{\"uName\":\"李四\",\"age\":38}");
        userCollection.insertOne(doc);
    }

    /**
     * 测试MongoDB的性能
     */
    @Test
    public void testXN(){//4166条/s
        long startTime = System.currentTimeMillis();
        for(int i = 1;i<=100000;i++){
            //将数据封装成Document的第2种方式
            Document doc2 = Document.parse("{\"uName\":\"test"+i+"\",\"age\":"+((int)Math.random()*100)+"}");
            userCollection.insertOne(doc2);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("共费时"+(endTime-startTime)/1000+"s");
    }

    /**
     * 批量插入
     */
    @Test
    public void insertMany(){
        //将数据封装成Document的第2种方式
        Document doc1 = Document.parse("{\"uName\":\"李四\",\"age\":38}");
        Document doc2 = Document.parse("{\"uName\":\"王二麻子\",\"age\":28}");
        Document doc3 = Document.parse("{\"uName\":\"张三\",\"age\":18}");
        //执行批量插入
        userCollection.insertMany(Arrays.asList(doc1,doc2,doc3));
    }

    //--------------------查询操作--------------------------------

    /**
     * 查询所有数据并且遍历
     */
    @Test
    public void selectAll(){
        FindIterable<Document> documents = userCollection.find();
        //遍历结果集，方式1：通过迭代器
        MongoCursor<Document> it = documents.iterator();
        /*while(it.hasNext()){
            Document tempDoc = it.next();
            System.out.println(tempDoc);
        }*/
        //方式2：通过lambda表达式
        it.forEachRemaining(temp-> System.out.println(temp));
    }

    /**
     * 分页查询数据
     */
    @Test
    public void selectByFY(){
        FindIterable<Document> documents = userCollection.find();
        documents.skip(2).limit(2);
        //遍历结果集，方式1：通过迭代器
        MongoCursor<Document> it = documents.iterator();
        //方式2：通过lambda表达式
        it.forEachRemaining(temp-> System.out.println(temp));
    }

    /**
     * 条件查询1:查询users集合中age>18岁的所有记录
     */
    @Test
    public void selectByCondition1(){
        //将查询条件构建成BSON，常用有三种方式
        //方式1：Document.parse(json)
        Document doc1 = Document.parse("{\"age\":{$gt:18}}");
        //方式2：直接构建Doucment
        Document doc2 = new Document("$gt",18);
        Document doc3 = new Document("age",doc2);
        //方式3:Filters类总有很多方法，可以用来封装条件
        Bson bson1 = Filters.gt("age", 18);

        FindIterable<Document> documents = userCollection.find(bson1);
        MongoCursor<Document> iterator = documents.iterator();
        iterator.forEachRemaining(temp-> System.out.println(temp));
    }

    /**
     * 条件查询2:查询users集合中：28<age<98
     */
    @Test
    public void selectByCondition2(){
        //将查询条件构建成BSON，常用有三种方式
        //方式1：Document.parse(json)
        Document doc1 = Document.parse("{$and:[{\"age\":{$gte:38}},{\"age\":{$lte:98}}]}");
        //方式3:Filters类总有很多方法，可以用来封装条件
        Bson bson1 = Filters.gt("age", 28);//条件1：age>28
        Bson bson2 = Filters.lt("age", 98);//条件2:age<98
        Bson bson3 = Filters.and(bson1, bson2);
        FindIterable<Document> documents = userCollection.find(bson3);
        MongoCursor<Document> iterator = documents.iterator();
        iterator.forEachRemaining(temp-> System.out.println(temp));
    }

    /**
     * 修改操作
     */
    @Test
    public void update(){
        Document doc1 = Document.parse("{\"uName\":\"李四\"}");
        Document doc2 = Document.parse("{$set:{\"age\":39}}");
        UpdateResult updateResult = userCollection.updateOne(doc1, doc2);
        System.out.println("updateReslut="+updateResult);
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        Document doc1 = Document.parse("{\"uName\":\"李四\"}");
        DeleteResult deleteResult = userCollection.deleteMany(doc1);
        System.out.println("deleteResult="+deleteResult);
    }

    @After
    public void after(){
        //5、关闭流
        mongoClient.close();
    }

}
