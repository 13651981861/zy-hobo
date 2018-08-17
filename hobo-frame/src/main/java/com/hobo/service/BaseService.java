package com.hobo.service;

import com.hobo.model.BaseModel;
import com.hobo.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * Created by lixianfeng on 2018/8/17.
 */
@Service
@Transactional(readOnly = true)
public class BaseService<T extends BaseModel,D extends BaseRepository<T,Long>>{
    @Autowired
    private D d;

    public T get(Long id){
        Optional<T> t = d.findById(id);
        if (t != null && t.isPresent()) {
            return t.get();
        }
        return null;
    }

    public List<T> list(){
        return d.findAll();
    }

    public Page<T> page(T t,Pageable pageable){
        Example<T> example = new Example<T>() {
            @Override
            public T getProbe() {
                return null;
            }
            @Override
            public ExampleMatcher getMatcher() {
                return null;
            }
        };
        return d.findAll(example,pageable);
    }

    @Transactional(readOnly = false)
    public T save(T t){
        return d.save(t);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        d.deleteById(id);
    }
}
