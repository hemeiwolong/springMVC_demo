package com.hmb.service;

import com.hmb.entity.User;
import com.hmb.entity.vo.MessageObject;
import com.hmb.mapper.UserMapper;
import com.hmb.util.GetSqlSession;
import com.hmb.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public MessageObject userLogin(String uname, String upwd) {
        User user = new User();
        user.setName(uname);
        user.setPwd(upwd);
        MessageObject messageObject = new MessageObject();
        messageObject.setMsg("login sucessfully!");
        messageObject.setCode(1);
        messageObject.setObject(user);
        StringUtil stringUtil = new StringUtil();

        if (stringUtil.isEmpty(uname) || stringUtil.isEmpty(upwd)) {
            messageObject.setCode(0);
            messageObject.setMsg("uname or upwd can not be null!");
            return messageObject;
        }

        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        user = userMapper.queryUserByName(uname);
        if (user == null) {
            messageObject.setCode(0);
            messageObject.setMsg("uname or upwd is not exist!");
            return messageObject;
        }

        messageObject.setObject(user);

        return messageObject;
    }
}
