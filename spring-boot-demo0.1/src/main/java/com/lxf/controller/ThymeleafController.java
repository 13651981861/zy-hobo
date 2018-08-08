package com.lxf.controller;

import com.lxf.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by lixianfeng on 2018/6/21.
 */
@Controller
@RequestMapping(value = "html")
public class ThymeleafController {
    @RequestMapping(value = "/index")
    public String index(ModelMap map){
        map.addAttribute("name","thymeleaf-lxf");
        return "index";
    }
    @RequestMapping(value = "test")
    public String test(ModelMap map){
        TestModel test = new TestModel();
        test.setId(1);
        test.setName("Thymeleaf学习");
        test.setCreateDate(new Date());
        map.put("dto",test);
        return "test";
    }
}
