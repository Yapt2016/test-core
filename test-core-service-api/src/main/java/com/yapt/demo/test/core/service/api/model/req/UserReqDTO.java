package com.yapt.demo.test.core.service.api.model.req;

import com.yapt.demo.test.core.service.api.model.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.oval.constraint.NotNull;

import java.util.Date;

/**
 * @author hurui
 * @version Id: UserDTO.java, v 0.1 2020/1/29 13:36 YaphetS Exp $$
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserReqDTO extends BaseDTO {
    private String name;
    private String phone;
    private String email;
    private String password;
    @NotNull(message = "城市id不能为空")
    private Integer cityId;
    private Date createTime;

    private Integer sex;
}