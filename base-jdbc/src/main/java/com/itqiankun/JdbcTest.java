package com.itqiankun;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class JdbcTest {

    public static void main(String[] args) {
        // 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/it_qk?characterEncoding=utf-8&allowMultiQueries=true&useSSL=false";
        String username = "root";
        String password = "root";

        // JDBC连接对象
        Connection connection = null;
        // JDBC语句对象
        Statement statement = null;
        // 结果集对象
        ResultSet resultSet = null;

        try {
            // 加载MySQL的JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 建立数据库连接
            connection = DriverManager.getConnection(url, username, password);

            // 创建Statement对象
            statement = connection.createStatement();

            // 执行SQL查询语句
            String sql = "SELECT * FROM user";
            statement.execute(sql);

            // 获取执行结果
            resultSet = statement.getResultSet();
            // 处理查询结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                log.info("id:{}, name:{}", id, name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
