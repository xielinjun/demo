package com.xlj.model.response;

import java.io.Serializable;

public class Response<T extends Serializable> extends BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -2876219006367557257L;

    /**
     * 返回结果类型
     */
    EnumResponseType responseType = EnumResponseType.DEFAULT;

    public EnumResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(EnumResponseType responseType) {
        this.responseType = responseType;
    }
}