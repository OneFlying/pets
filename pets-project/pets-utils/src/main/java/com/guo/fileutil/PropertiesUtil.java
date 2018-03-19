package com.guo.fileutil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件读取工具类
 * @author guolejian
 */
public class PropertiesUtil {
    private static class Holder {
        private static final PropertiesUtil INSTANCE = new PropertiesUtil();
    }

    private PropertiesUtil() {}

    public static final PropertiesUtil getInstance() {
        return Holder.INSTANCE;
    }

    public String getValueByKey(String fileName, String key) {
        try {
            InputStream inputStream = PropertiesUtil.class.getResourceAsStream("/"+fileName);
            Properties properties = new Properties();
            properties.load(inputStream);

            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();
        String value =
                propertiesUtil.getValueByKey("rediscluster.properties", "hostandport");
        System.out.println(value);
    }

}
