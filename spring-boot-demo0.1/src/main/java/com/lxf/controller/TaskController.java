package com.lxf.controller;

import com.lxf.tasks.SyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Future;

/**
 * Created by lixianfeng on 2018/7/25.
 * 异步任务练习
 *      异步任务使用场景   发送短信  发送邮件 App消息推送 凌晨任务同步执行
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private SyncTask syncTask;
    @RequestMapping(value = "")
    public void doTask(HttpServletRequest request,HttpServletResponse response) throws Exception{
        long start = System.currentTimeMillis();
        Future<Boolean> a = syncTask.task1();
        Future<Boolean> b = syncTask.task2();
        Future<Boolean> c = syncTask.task3();
        //死循环  当三个任务都结束之后 跳出循环
        while (!a.isDone() || !b.isDone() || !c.isDone()){
            if (a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        String times = "任务全部完成,耗时:" + (end - start) + "毫秒";
        System.out.println(times);
        response.getOutputStream().write(times.getBytes("utf-8"));
    }
}
