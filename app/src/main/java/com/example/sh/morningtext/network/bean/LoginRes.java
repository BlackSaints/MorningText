package com.example.sh.morningtext.network.bean;

public class LoginRes {

    public String code;
    public String msg;
    public String userId;
    public String isRealtyName;
    public String userName;


    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsRealtyName() {
        return isRealtyName == null ? "" : isRealtyName;
    }

    public void setIsRealtyName(String isRealtyName) {
        this.isRealtyName = isRealtyName;
    }

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
