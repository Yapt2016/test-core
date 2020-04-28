package com.yapt.demo.test.core.service.api.model.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hurui
 * @version Id: MsgResult.java, v 0.1 2020/4/28 18:55 YaphetS Exp $$
 */
@Data
public class MsgResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean success;
    private T result;
    private String errorCode;
    private String errorMsg;

    public MsgResult() {

    }

    public MsgResult(T result) {
        this.success = true;
        this.result = result;
    }

    public MsgResult(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public void setErrorCode(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.success = false;
        this.errorMsg = errorMsg;
    }
}