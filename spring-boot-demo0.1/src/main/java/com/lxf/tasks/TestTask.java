package com.lxf.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lixianfeng on 2018/7/25.
 */

/**
 * 组件 容器加载时会扫描
 */
@Component
public class TestTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedRate = 3000)
    public void task1(){
        System.out.println(dateFormat.format(new Date()));
    }

    /**
     * cron表达式通过 http://cron.qqe2.com 生成工具生成 (springboot 不支持年)
     */
    @Scheduled(cron = "0 0 0 1 * ? ")
    public void task2(){
        System.out.println(dateFormat.format(new Date()));
    }
}
