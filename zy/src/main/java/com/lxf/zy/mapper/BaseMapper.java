package com.lxf.zy.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by lixianfeng on 2018/6/12.
 */
@Mapper
public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);
    int insert(T record);
    int insertSelective(T record);
    T selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(T record);
    int updateByPrimaryKey(T record);
}
