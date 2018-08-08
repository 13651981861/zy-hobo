package com.lxf.config;

import com.lxf.interceptors.CharsetInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lixianfeng on 2018/7/25.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CharsetInterceptors()).addPathPatterns("/task/**");
        super.addInterceptors(registry);
    }
}
