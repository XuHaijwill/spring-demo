package com.shardingjdbc.dao;

import org.junit.jupiter.api.Test;

import java.sql.*;


import java.sql.*;

public class TestJDBC {

    @Test
    public void test() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2.创建连接
            conn = DriverManager.getConnection("jdbc:mysql://192.168.0.108:3366/ds0?useSSL=false", "root", "11111");

            // 开启事务
            conn.setAutoCommit(false);

            // 获得sql执行者  ：
            // 1. 执行预处理
            String sql = "select * from t_order2021 where id=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            // 执行查询
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            rs.next();

            // 提交事务
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            // 回滚事务
            conn.rollback();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally{
            // 关闭资源
            try {
                if(conn!=null){
                    conn.close();
                }
                if(pstmt!=null){
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}