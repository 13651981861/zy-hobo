package com.example.demo.controller;

import com.lxf.model.SysUser;
import com.lxf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixianfeng on 2018/6/12.
 */
@Controller
public class LoginController extends BaseController{

    @RequestMapping(value = "login")
    public String login(){
        return "/login";
    }
    @RequestMapping(value = "doLogin")
    public String doLogin(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if ("admin".equals(userName) && "123456".equals(passWord)){
            request.setAttribute("name","jack");
            return "/index";
        }
        String msg = "登录失败!";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/login";
    }

    @Autowired
    private SysUserService sysUserService;
    @RequestMapping(value = "get")
    public String get(HttpServletRequest request,HttpServletResponse response){
        Integer id = Integer.parseInt(request.getParameter("id"));
        SysUser sysUser = sysUserService.get(id);
        request.setAttribute("sysUser", sysUser);
        return "/sys/info";
    }

}
