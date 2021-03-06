package com.lxf.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by lixianfeng on 2018/6/13.
 */
@Configuration
@MapperScan(basePackages = "com.lxf.*.mapper")
public class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource readDataSource(){
        DruidDataSource source =  new DruidDataSource();
        return source;
    }
}
