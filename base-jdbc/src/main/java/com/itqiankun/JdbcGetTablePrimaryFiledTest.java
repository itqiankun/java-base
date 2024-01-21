package com.itqiankun;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class JdbcGetTablePrimaryFiledTest {
    private static Connection connection;

    public static void main(String[] args) throws Exception {
        JdbcGetTablePrimaryFiledTest test = new JdbcGetTablePrimaryFiledTest();
        Map<String, String> stringMap = test.getFirstFiledMap();
        log.info("tableName keyFirst:{}", JSONObject.toJSON(stringMap));

        generationFile(stringMap);







    }

    private static void generationFile(Map<String, String> stringMap) throws Exception {
        for (String tableName : stringMap.keySet()) {
            PrintWriter printWriter = new PrintWriter("/Users/mqk/Desktop/mqk-worker/mqk-code/java-base/base-jdbc/file/"+tableName+".yml");
            printWriter.write("dataSourceKey: defaultDS\n" +
                    "destination: example\n" +
                    "groupId: g1\n" +
                    "outerAdapterKey: mysql1\n" +
                    "concurrent: true\n" +
                    "dbMapping:\n" +
                    "  database: huizhi\n" +
                    "  table: "+tableName+"\n" +
                    "  targetTable: "+tableName+"\n" +
                    "  targetPk:\n" +
                    "    id: "+stringMap.get(tableName)+"\n" +
                    "  mapAll: true\n" +
                    "  commitBatch: 3000 # 批量提交的大小\n");
            printWriter.close();
        }
    }

    private Map<String, String> getFirstFiledMap() throws Exception {
        ConcurrentMap<String, String> concurrentMap = Maps.newConcurrentMap();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getColumns(null, null, "%", "%");
        Set<String> tableNames = Sets.newConcurrentHashSet();
        while (resultSet.next()) {
            // 获取字段信息
            String tableName = resultSet.getString("TABLE_NAME");
            tableNames.add(tableName);
        }
        for (String tableName : tableNames) {
            ResultSet resultSetTemp = databaseMetaData.getPrimaryKeys(null, null, tableName);
            while (resultSetTemp.next()){
                // 获取主键信息
                String columnName = resultSetTemp.getString("COLUMN_NAME");
                concurrentMap.put(tableName, columnName);
//                log.info("tableName:{}, Primary Key Column: {}" ,tableName, columnName);
            }
        }
        return concurrentMap;
    }

    static {
        try{
            Properties info = new Properties(); // 定义Properties对象
            info.setProperty("user", "root"); // 设置Properties对象属性
            info.setProperty("password", "root");
            Class.forName("com.mysql.jdbc.Driver"); // 注册数据库驱动
            String url = "jdbc:mysql://localhost:3306/huizhi?characterEncoding=utf-8&allowMultiQueries=true&useSSL=false"; // briup为数据库名称
            connection = DriverManager.getConnection(url, info); // 获取连接数据库的Connection对象
        } catch (Exception e) {
            log.error("autoCodeGeneratorProcess error ", e);
        }
    }

}
