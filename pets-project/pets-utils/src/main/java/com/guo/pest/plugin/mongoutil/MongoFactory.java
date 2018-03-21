package com.guo.pest.plugin.mongoutil;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.util.ArrayList;
import java.util.List;

public class MongoFactory {

    private MongoClient mongoClient = null;

    // mongo 内部实现连接池 只要保证mongobd客户端是单例即可
    // 保证多线程下创建的是同一个对象， jvm保证了安全性
    private static class Holder {
        public static MongoFactory INSTANCE = new MongoFactory();
    }

    // 保证不被外界new
    private MongoFactory() {
        List<ServerAddress> address = new ArrayList<>();
        // mongodb 集群ip 将来放入属性文件中
        address.add(new ServerAddress("192.168.110.133", 20000));// mongos地址
        address.add(new ServerAddress("192.168.110.134", 20000));// mongos地址

        mongoClient = new MongoClient(address);
    };

    public static MongoFactory getInstance() {
        return Holder.INSTANCE;
    }

}
