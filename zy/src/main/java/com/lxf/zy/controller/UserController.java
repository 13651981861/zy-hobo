package com.lxf.zy.controller;

import com.lxf.zy.model.SysUser;
import com.lxf.zy.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixianfeng on 2018/8/6.
 */
@Controller
public class UserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping(value = {""})
    public String login(){
        return "login";
    }

    @ModelAttribute
    public SysUser addUser(@Param("id") Long id){
        if (id == null){
            return new SysUser();
        }else{
            return sysUserService.get(id);
        }
    }

    @RequestMapping(value = "login")
    public String login(HttpServletRequest request,HttpServletResponse response){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassWord(passWord);
        SysUser loginUser = sysUserService.info(sysUser);
        if (loginUser != null && loginUser.getUserName().equals(userName)){
            request.getSession().setAttribute("currentUser",loginUser);
            request.setAttribute("user",loginUser);
            return "page/index";
        }
        return "login";
    }


}
