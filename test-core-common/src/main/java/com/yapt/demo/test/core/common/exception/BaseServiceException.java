package com.yapt.demo.test.core.common.exception;

/**
 * @author hurui
 * @version Id: BaseServiceException.java, v 0.1 2020/10/15 14:00 YaphetS Exp $$
 */
public class BaseServiceException extends RuntimeException {

    /**
     * 错误枚举
     */
    private ErrorCode errorCode;

    /**
     * 额外的异常描述
     */
    private String extraMsg;

    public BaseServiceException(ErrorCode errorCode, String extraMsg,Throwable cause) {
        super(getMessage(errorCode, extraMsg), cause);
        this.errorCode = errorCode;
        this.extraMsg = extraMsg;
    }

    public BaseServiceException(ErrorCode errorCode,String extraMsg) {
        super(getMessage(errorCode, extraMsg), null);
        this.errorCode = errorCode;
        this.extraMsg = extraMsg;
    }

    public BaseServiceException(ErrorCode errorCode,Throwable cause) {
        super(getMessage(errorCode, null), cause);
        this.errorCode = errorCode;
    }

    public BaseServiceException(ErrorCode errorCode) {
        super(getMessage(errorCode, null), null);
        this.errorCode = errorCode;
    }

    private static String getMessage(ErrorCode errorCode, String extraMsg) {
        extraMsg = null != extraMsg ? extraMsg : "";
        return MessageHelper.formatMsg("错误码:{0}, 描述:{1}, 异常信息:{2}",errorCode.getCode(), errorCode.getDesc(), extraMsg);
    }
}