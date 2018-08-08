package com.lxf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixianfeng on 2018/6/21.
 */
@Controller
@RequestMapping(value = "/exception")
public class ExceptionController {
    @RequestMapping(value = "/index")
    public String index(){
        int a = 1 /  0;
        return "/index";
    }
}
