package com.lxf.model;

import java.util.Date;

/**
 * Created by lixianfeng on 2018/6/21.
 */
public class TestModel {
    private int id;
    private String name;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
