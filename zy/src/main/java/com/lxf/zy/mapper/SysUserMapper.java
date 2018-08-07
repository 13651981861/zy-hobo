package com.lxf.zy.mapper;

import com.lxf.zy.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser>{
    List<SysUser> list(SysUser sysUser);
    SysUser info(SysUser sysUser);
}