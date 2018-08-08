package com.lxf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by lixianfeng on 2018/7/24.
 */
@Configuration
public class ResolverConfig extends WebMvcConfigurerAdapter{
    @Value("${spring.mvc.view.prefix}")
    private String prefix;
    @Value("${spring.mvc.view.suffix}")
    private String suffix;
    @Value("${spring.mvc.view.view-name}")
    private String viewNames;
    @Value("${spring.mvc.view.order}")
    private int order;
    @Bean
    InternalResourceViewResolver jspResolver(){
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(prefix);
        viewResolver.setSuffix(suffix);
        viewResolver.setViewNames(viewNames);
        viewResolver.setOrder(order);
        return viewResolver;
    }
}
