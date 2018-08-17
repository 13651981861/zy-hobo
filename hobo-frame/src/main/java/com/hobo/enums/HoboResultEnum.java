package com.hobo.enums;

/**
 * Created by lixianfeng on 2018/8/16.
 */
public enum HoboResultEnum {
    HOBO_RESULT_OK(0,"成功"),
    HOBO_RESULT_VALID(100,"验证不通过"),
    HOBO_RESULT_ERROR(-1,"系统错误"),

    USER_SAVE_NAME(50,"用户名已存在")
    ;

    private int code;
    private String msg;

    HoboResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    /**
     * 动态创建枚举属性
     * @param str
     * @return
     */
    public static HoboResultEnum newEnum(String str){
        return valueOf(str);
    }
}
