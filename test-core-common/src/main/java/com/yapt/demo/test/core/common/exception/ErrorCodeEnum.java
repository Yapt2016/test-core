package com.yapt.demo.test.core.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hurui
 * @version Id: ErrorCodeEnum.java, v 0.1 2020/10/15 14:12 YaphetS Exp $$
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum implements ErrorCode{

    /**
     * 非法参数
     */
    ILLEGE_PARAMETER("ILLEGE_PARAMETER","非法参数");


    /**
     * 异常码
     */
    private String code;

    /**
     * 异常描述
     */
    private String desc;

}