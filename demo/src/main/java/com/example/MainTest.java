package com.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by XGH on 2019/5/15
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object o = sqlSession.selectOne("com.example.mapper.StudentMapper.findById", 1);
        System.out.println(o);
        sqlSession.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        Object o1 = sqlSession2.selectOne("com.example.mapper.StudentMapper.findById", 1);
        System.out.println(o1);
        sqlSession2.close();


    }
}
