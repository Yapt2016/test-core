package com.yapt.demo.test.core.dao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hurui
 * @version Id: BaseDO.java, v 0.1 2019/8/20 10:52 YaphetS Exp $$
 */
@Getter
@Setter
@ToString
public class BaseDO implements Serializable {
    private static final long serialVersionUID = -8121717571700989220L;
    /**
     * 数据库主键
     */
    private Long   id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date   updatedAt;
    /**
     * 最后更新人
     */
    private String updatedBy;
}