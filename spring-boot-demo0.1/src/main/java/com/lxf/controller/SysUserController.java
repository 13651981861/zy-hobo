package com.lxf.controller;

import com.lxf.model.SysUser;
import com.lxf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lixianfeng on 2018/6/12.
 */
@Controller
@RequestMapping(value = "/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/get")
    public String get(HttpServletRequest request,HttpServletResponse response){
        Integer id = Integer.parseInt(request.getParameter("id"));
        SysUser sysUser = sysUserService.get(id);
        request.setAttribute("sysUser",sysUser);
        return "/sys/info";
    }

    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request,HttpServletResponse response) {
        try {
            List<SysUser> sysUsers = sysUserService.list(SysUser.class.newInstance());
            request.setAttribute("sysUsers",sysUsers);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "/sys/list";
    }

    @ResponseBody
    @RequestMapping(value = "getUser")
    public SysUser getUser(){
        System.out.println("json user test tt");
        SysUser user = new SysUser();
        user.setUsername("热部署测试");
        return user;
    }
}
