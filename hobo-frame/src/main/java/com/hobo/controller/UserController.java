package com.hobo.controller;

import com.hobo.enums.HoboResultEnum;
import com.hobo.exception.HoboException;
import com.hobo.model.BaseModel;
import com.hobo.model.Result;
import com.hobo.model.User;
import com.hobo.repository.BaseRepository;
import com.hobo.repository.UserRepository;
import com.hobo.service.BaseService;
import com.hobo.service.UserService;
import com.hobo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lixianfeng on 2018/8/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<User,BaseService<User,BaseRepository<User,Long>>>{

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/byName")
    public List<User> list(@RequestParam String name){
        return  userService.findList(name);
    }

    @Override
    public Result save(@Valid User user, BindingResult bindingResult) {
        //验证用户名不能重复
        List<User> users = userService.findByName(user.getName());
        if (users != null && users.size() > 0){
            return ResultUtil.error(HoboResultEnum.USER_SAVE_NAME);
        }
        return ResultUtil.ok(super.save(user, bindingResult));
    }
}
