package com.hobo.exception;

import com.hobo.enums.HoboResultEnum;
import com.hobo.model.Result;
import com.hobo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lixianfeng on 2018/8/16.
 */
public class HoboException extends RuntimeException{
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HoboException(HoboResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public HoboException(int code,String msg) {
        super(msg);
        this.code = code;
    }
}
