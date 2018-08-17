package com.hobo.model;

import org.springframework.data.annotation.Transient;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by lixianfeng on 2018/8/17.
 */
@MappedSuperclass
public class BaseModel implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

//    /**
//     * 该字段不映射成子类字段
//     */
//    @Transient
//    private String testFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Transient
//    public String getTestFile() {
//        return testFile;
//    }
//
//    @Transient
//    public void setTestFile(String testFile) {
//        this.testFile = testFile;
//    }
}
