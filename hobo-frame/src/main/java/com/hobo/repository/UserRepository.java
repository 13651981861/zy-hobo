package com.hobo.repository;

import com.hobo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * Created by lixianfeng on 2018/8/16.
 * JpaSpecificationExecutor 支持多条件查询接口
 *
 */
public interface UserRepository extends BaseRepository<User,Long>{
    /**
     * @Query sql 查询, 区分大小写 user
     * @param name
     * @return
     */
    @Query(value = "select * from user u where u.name like concat('%',:name,'%') ",nativeQuery = true)
    public List<User> findListByName(@Param("name") String name);
    //findByNameLike 根据方法命名查询


    public List<User> findByName(String name);
}
