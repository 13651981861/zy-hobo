package com.lxf.exception;

/**
 * Created by lixianfeng on 2018/7/24.
 */
public class ResultJson<T> {
    private Integer status;
    private String msg;
    T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultJson(T data){
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
    public ResultJson(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
