package com.hmb.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSession {
    public static SqlSession createSqlSession() {
        InputStream input = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession session = null;
        String resource = "mybatis-config.xml";

        try {
            input = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
            session = sqlSessionFactory.openSession();
            return session;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(GetSqlSession.createSqlSession());
    }
}
