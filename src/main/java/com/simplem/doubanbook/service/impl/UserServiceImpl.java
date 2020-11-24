package com.simplem.doubanbook.service.impl;

import com.simplem.doubanbook.mapper.UserMapper;
import com.simplem.doubanbook.model.User;
import com.simplem.doubanbook.service.UserService;
import com.simplem.doubanbook.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.simplem.doubanbook.service.impl
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 11:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        user.setPassword(MD5Utils.code(user.getPassword()));
        return userMapper.login(user);
    }
}
