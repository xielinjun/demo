package com.xlj.model;

import java.io.Serializable;

/**
 * 用户信息
 */
public class User extends BaseModel implements Serializable {

    private static final long serialVersionUID = -6171208019792462715L;

    /**
     * 用户id
     */
    String id;

    /**
     * 用户显示名
     */
    String showName;

    /**
     * 用户真名
     */
    String realName;

    /**
     * 证件id
     */
    String idNum;

    /**
     * 电话
     */
    String phone;

    /**
     * 邮箱
     */
    String email;

    /**
     * ID卡类型

     */
    EnumUserIDType idType = EnumUserIDType.IDCARD;

    public EnumUserIDType getIdType() {
        return idType;
    }

    public void setIdType(EnumUserIDType idType) {
        this.idType = idType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

}
