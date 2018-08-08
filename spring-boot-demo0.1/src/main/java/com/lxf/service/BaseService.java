package com.lxf.service;

import com.lxf.mapper.BaseMapper;
import com.lxf.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lixianfeng on 2018/6/12.
 */
@Service
public class BaseService<T extends BaseModel,D extends BaseMapper<T>> {
    @Autowired
    private D dao;
    public T get(Integer id){
        return dao.selectByPrimaryKey(id);
    }
    public List<T> list(T t){
        return dao.list(t);
    };
    public int save(T t){
        if (t.getId() == null){
            return dao.insert(t);
        }else{
            return dao.updateByPrimaryKey(t);
        }
    }
    public int delete(Integer id){
        return dao.deleteByPrimaryKey(id);
    }
}
