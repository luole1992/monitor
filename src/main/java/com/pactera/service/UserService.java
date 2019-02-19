package com.pactera.service;

import com.pactera.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUser();
    public User findUserAddr(String username);
}
