package com.example.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionLoader {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
        try {
            InputStream inputStream =
                    Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSessionFactory = new
                    SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        return sqlSessionFactory;
    }
    public static SqlSession getSqlSession() throws IOException {
        return getSqlSessionFactory().openSession();
    }
}