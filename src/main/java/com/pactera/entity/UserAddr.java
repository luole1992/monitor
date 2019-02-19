package com.pactera.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname UserAddr
 * @Author luole
 * @Date 2018/12/10 0010 14:16
 * @Description TODO
 * @Version 1.0
 **/
@Data
@TableName("t_useraddr")
public class UserAddr {
    private Integer id;
    private Integer usernameid;
    private String province;
    private String city;
}
