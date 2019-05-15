package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.CountDownLatch;

/**
 * Created by XGH on 2019/4/10
 */
public class MyConnector implements Runnable {

    private CountDownLatch countDown;

    public MyConnector(CountDownLatch countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meituan?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "1234");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            conn.setAutoCommit(false);
            //不加锁的情况
            PreparedStatement ps = conn.prepareStatement("select * from count where id =1");
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("count");
                System.out.println("di"+count+" "+Thread.currentThread().getName());
            }
            count++;

            ps = conn.prepareStatement("update count set count=? where id =1");
            ps.setInt(1, count);
            ps.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
            return;
        }

        countDown.countDown();
    }
}
