package com.lxf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixianfeng on 2018/6/21.
 */
@ControllerAdvice
public class DemoExceptionHandler {
    private static final String ERROR = "/error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,HttpServletResponse response,Exception e){
        e.printStackTrace();
        if (isAjax(request)){
            return new ResultJson(500,"error",response);
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url", request.getRequestURI());
            mav.setViewName(ERROR);
            return mav;
        }
    }

    /**
     * 判断是否Ajax请求
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
