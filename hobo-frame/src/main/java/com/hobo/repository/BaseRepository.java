package com.hobo.repository;

import com.hobo.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lixianfeng on 2018/8/17.
 */
public interface BaseRepository<T extends BaseModel,Long> extends JpaRepository<T,Long>,JpaSpecificationExecutor<T> {

}
