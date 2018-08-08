package com.lxf.repository;

import com.lxf.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lixianfeng on 2018/7/25.
 *  {@link com.lxf.model.User} {@Repository}
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式 map
     */
    private ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();
    /**
     * 创建ID生成器
     */
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用对象
     * @param user
     * @return
     */
    public Boolean save(User user){
        //id 从 1  开始
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    public Collection<User> findAllUser(){
        return repository.values();
    }
}
