package com.hobo.controller;

import com.hobo.enums.HoboResultEnum;
import com.hobo.model.BaseModel;
import com.hobo.model.Result;
import com.hobo.repository.BaseRepository;
import com.hobo.service.BaseService;
import com.hobo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lixianfeng on 2018/8/17.
 */
@RestController
public class BaseController<T extends BaseModel,D extends BaseService<T,BaseRepository<T,Long>>>{
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private D d;

    @GetMapping(value = "")
    public List<T> list(){
        return d.list();
    }

    @PostMapping(value = "")
    public Result save(@Valid T t,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.valid(bindingResult.getFieldError().getDefaultMessage());
        }
        T obj = d.save(t);
        return ResultUtil.ok(obj);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public T get(@PathVariable(value = "id") Long id){
        return d.get(id);
    }

    /**
     * 更新
     * @param t
     * @return
     */
    @PutMapping(value = "/{id}")
    public T put(T t){
        return d.save(t);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        d.delete(id);
    }

}
