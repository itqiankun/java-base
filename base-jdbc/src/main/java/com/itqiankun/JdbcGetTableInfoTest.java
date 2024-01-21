package com.itqiankun;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Properties;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class JdbcGetTableInfoTest {
    private static Connection connection;

    public static void main(String[] args) throws Exception {
        JdbcGetTableInfoTest test = new JdbcGetTableInfoTest();
        // 第一种方式：执行sql语句获取 select * from dims where 1 = 2
            test.method1();
        // 第二种方式：执行sql语句获取 show create table dims
            test.method2();
        // 第三种方式：直接从jdbc数据库连接Connection实例中获取
            test.method3();
    }

    private void method1() {
            try{
                PreparedStatement preparedStatement = connection.prepareStatement("select * from user where 1 = 2");
                ResultSetMetaData resultSetMetaData = preparedStatement.executeQuery().getMetaData();
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    log.info("实例名:{}", resultSetMetaData.getCatalogName(i + 1));
                    log.info("表名:{}", resultSetMetaData.getTableName(i + 1));
                    log.info("类型:{}", resultSetMetaData.getColumnClassName(i + 1));
                    log.info("列类型:{}", resultSetMetaData.getColumnTypeName(i + 1));
                    log.info("字段名称:{}", resultSetMetaData.getColumnName(i + 1));
                    log.info("字段长度:{}", resultSetMetaData.getColumnDisplaySize(i + 1));
                    log.info("getColumnType:{}", resultSetMetaData.getColumnType(i + 1));
                    log.info("getPrecision:{}", resultSetMetaData.getPrecision(i + 1));
                    log.info("getScale:{}", resultSetMetaData.getScale(i + 1));
                    log.info("getSchemaName:{}", resultSetMetaData.getSchemaName(i + 1));
                    log.info("getScale:{}", resultSetMetaData.getScale(i + 1));
                }
            } catch (Exception e) {
                log.error("method1 error ", e);
            }
        }

        private void method2() {
            try{
                PreparedStatement preparedStatement2 = connection.prepareStatement("show create table user");
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()) {
                    String tableName = resultSet2.getString("Table");
                    String createTable = resultSet2.getString("Create Table");
                    log.info("tableName:{}", tableName);
                    log.info("createTable:");
                    System.out.println(createTable);
                }
            } catch (Exception e) {
                log.error("method2 error ", e);
            }
        }

        private void method3() {
            try{
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                // 获取所有表
                ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
                // 获取指定表
                ResultSet specificResultSet = databaseMetaData.getColumns(null, "%", "user", "%");
                String columnName2;
                String columnType2;
                String comment2;
                while(specificResultSet.next()) {
                    columnName2 = specificResultSet.getString("COLUMN_NAME");
                    columnType2 = specificResultSet.getString("TYPE_NAME");
                    comment2 = specificResultSet.getString("REMARKS");
                    log.info("COLUMN_NAME:{}", columnName2);
                    log.info("TYPE_NAME:{}", columnType2);
                    log.info("REMARKS:{}", comment2);
                }
            } catch (Exception e) {
                log.error("method3 error ", e);
            }
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
