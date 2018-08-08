package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixianfeng on 2018/6/11.
 */
@Controller
@RequestMapping(value = "index")
public class IndexController {

    @RequestMapping(value = "")
    public String hello(HttpServletRequest request,HttpServletResponse response){
        String name = "Jack";
        request.setAttribute("name",name);
        return "/index";
    }

}
