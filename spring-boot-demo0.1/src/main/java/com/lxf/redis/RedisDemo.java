package com.lxf.redis;

import com.lxf.exception.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by lixianfeng on 2018/6/13.   redis缓存
 */
@Controller
@RequestMapping(value = "redis")
public class RedisDemo {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "set")
    public ResultJson set(String key,String value){
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set("abc","cva");
            return new ResultJson("ok");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取缓存
     * @param request
     * @return
     */
    @RequestMapping(value = "get")
    public String get(HttpServletRequest request){
        String key = request.getParameter("key");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        request.setAttribute("redis.key",valueOperations.get(key));
        return "/index";
    }


    @RequestMapping(value = "/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID)session.getAttribute("uid");
        if (uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
