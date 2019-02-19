package com.pactera.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pactera.entity.User;
import com.pactera.mapper.UserMapper;
import com.pactera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired

    private UserService userService;

    @RequestMapping("/getuser")
    @ResponseBody
    public List<User> getUser(){
        return userService.getUser();
    }

    @RequestMapping("/finduseraddr")
    @ResponseBody
    public User findUserAddr(){
        return userService.findUserAddr("罗乐");
    }
}
