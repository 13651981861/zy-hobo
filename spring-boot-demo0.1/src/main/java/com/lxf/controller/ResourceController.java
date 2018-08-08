package com.lxf.controller;

import com.lxf.model.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixianfeng on 2018/6/20.  配置资源文件
 */
@RestController
@RequestMapping(value = "resource")
public class ResourceController {
    @Autowired
    private Resource resource;
    @RequestMapping(value = "get")
    public Resource getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return bean;
    }
}
