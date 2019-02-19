package com.pactera.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pactera.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    public List<User> getUser();
    public User findUserAddr(String username);
}
