package com.hobo.handle;

import com.hobo.enums.HoboResultEnum;
import com.hobo.exception.HoboException;
import com.hobo.model.Result;
import com.hobo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * Created by lixianfeng on 2018/8/16.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        if (e instanceof HoboException){
            HoboException hoboException = (HoboException)e;
            return ResultUtil.error(hoboException.getCode(),hoboException.getMessage());
        }else{
            logger.error("系统异常{}",e);
            return ResultUtil.error(HoboResultEnum.HOBO_RESULT_ERROR);
        }
    }
}
