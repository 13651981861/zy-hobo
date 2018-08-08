package com.lxf.controller;

import com.lxf.model.User;
import com.lxf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixianfeng on 2018/7/25.
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    /**
     * 采用构造器方式注入  好处是:不能修改 提早初始化 提捉
     * @param userRepository  由 spring 传参
     */
    @Autowired  //可写 可不写 ,可视化
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.printf("用户对象: %s 保存成功",user);
            System.out.printf("");
        }
        return  user;
    }
}
