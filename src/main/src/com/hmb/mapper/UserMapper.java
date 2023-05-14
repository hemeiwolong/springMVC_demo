package com.hmb.mapper;

import com.hmb.entity.User;

public interface UserMapper {
    User queryUserByName(String username);
}
