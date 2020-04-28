package com.yapt.demo.test.core.service.api.model.res;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hurui
 * @version Id: UserResDTO.java, v 0.1 2020/2/1 18:08 YaphetS Exp $$
 */
@Data
public class UserResDTO implements Serializable {
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}