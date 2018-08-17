package com.lxf.zy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixianfeng on 2018/8/14.
 */
public class Demo {
    /**
     * age
     */
    private int age;
    /**
     * name
     */
    private String name;

    /**
     * money
     */
    private int money;

    /**
     * pwd
     */
    private String pwd;

    List<String> list = new ArrayList<String>();

    Map<String, Object> map = new HashMap<String, Object>();

    public static void main(String[] params) {
        aa(params);
        System.out.println(params);
    }

    private static void aa(String[] params) {
        System.out.println(params);
    }

    public SysUser getUser(){
        List<String> list = new ArrayList<String>();
        list(list);
        return getSysUser();
    }

    private void list(List<String> list) {
        if (list != null) {
            for (String s : list) {
                System.out.println(s);
            }
        }
        if (map != null) {

        }
        if (list != null) {

        }
    }

    private SysUser getSysUser() {
        return new SysUser();
    }
}
