package com.hobo.utils;

import com.hobo.enums.HoboResultEnum;
import com.hobo.model.Result;

/**
 * Created by lixianfeng on 2018/8/16.
 */
public class ResultUtil {
    public static Result ok(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result ok(){
        return ok(null);
    }

    public static Result error(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 验证异常 code 为 222 ,msg 自定义
     * @param msg
     * @return
     */
    public static Result valid(String msg){
        return error(222,msg);
    }

    public static Result error(HoboResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }
}
