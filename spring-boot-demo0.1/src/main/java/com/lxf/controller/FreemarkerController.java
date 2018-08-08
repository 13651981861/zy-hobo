package com.lxf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lixianfeng on 2018/6/21.
 */
@Controller
@RequestMapping(value = "ftl")
public class FreemarkerController {
    @RequestMapping(value = "/index")
    public String index(ModelMap map){
        map.addAttribute("name","FreeMarker");
        map.addAttribute("url","https://www.imooc.com/video/16720/0");
        return "ftl/index";
    }
}
