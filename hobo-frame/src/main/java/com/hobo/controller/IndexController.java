package com.hobo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixianfeng on 2018/8/16.
 */
@RestController
public class IndexController {
    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String welcome(){
        return "Welcome to Spring Boot from Hobo";
    }
}
