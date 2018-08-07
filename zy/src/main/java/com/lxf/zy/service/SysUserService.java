package com.lxf.zy.service;

import com.lxf.zy.mapper.SysUserMapper;
import com.lxf.zy.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lixianfeng on 2018/6/12.
 */
@Service
public class SysUserService extends BaseService<SysUser,SysUserMapper>{

    @Autowired
    private SysUserMapper sysUserMapper;
    public List<SysUser> list(SysUser sysUser){
        return sysUserMapper.list(sysUser);
    };
    public SysUser info(SysUser sysUser){
        return sysUserMapper.info(sysUser);
    }
}
