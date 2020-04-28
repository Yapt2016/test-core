package com.yapt.demo.test.core.dao.model;

import lombok.Data;

import java.util.Date;

/**
 * @author hurui
 * @version Id: UserDO.java, v 0.1 2020/1/13 17:29 YaphetS Exp $$
 */
@Data
public class UserDO extends BaseDO {

    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}