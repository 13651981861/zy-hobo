package com.hobo.service;

import com.hobo.model.User;
import com.hobo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lixianfeng on 2018/8/16.
 */
@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<User,UserRepository>{
    @Autowired
    private UserRepository userRepository;

    //自身服务方法
    public List<User> findList(String name){
        return userRepository.findListByName(name);
    }
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }
}
