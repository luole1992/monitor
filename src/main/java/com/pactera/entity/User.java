package com.pactera.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("t_user")
public class User implements Serializable {
    private Integer userid;
    private String username;
    private String password;
    private String phone;
    private List<UserAddr> userAddrList;
}
