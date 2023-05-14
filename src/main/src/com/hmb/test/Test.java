package com.hmb.test;

import com.hmb.entity.User;
import com.hmb.mapper.UserMapper;
import com.hmb.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByName("zhangsan");
        System.out.println(user);
    }
}
