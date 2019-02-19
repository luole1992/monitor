package com.pactera.service.impl;

import com.pactera.entity.User;
import com.pactera.mapper.UserMapper;
import com.pactera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUser() {
        return userMapper.getUser();
    }

    @Override
    public User findUserAddr(String username) {
        return userMapper.findUserAddr(username);
    }
}
