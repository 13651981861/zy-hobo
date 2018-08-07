package com.lxf.zy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixianfeng on 2018/8/6.
 */
@Controller
public class DemoController {

    @ResponseBody
    @RequestMapping("demo")
    public String demo(){
        return "welcome to spring boot";
    }

    @RequestMapping("thymeleaf")
    public String thymeleaf(){
        return "page/index";
    }
}
