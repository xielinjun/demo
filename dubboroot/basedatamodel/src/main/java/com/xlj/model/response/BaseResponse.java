package com.xlj.model.response;

import com.xlj.model.BaseModel;

import java.io.Serializable;

/**
 * 所有返回对象的基类
 * @param <T>
 */
public class BaseResponse<T extends Serializable> extends BaseModel implements Serializable {
    private static final long serialVersionUID = -2079551372263710983L;

    /**
     * 返回时携带的对象
     */
    T result;

    /**
     * 返回的消息
     */
    String comment;

    /**
     * 返回时携带的对象
     */
    public T getResult() {
        return result;
    }

    /**
     * 返回时携带的对象
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * 返回的消息
     */
    public String getComment() {
        return comment;
    }

    /**
     * 返回的消息
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
