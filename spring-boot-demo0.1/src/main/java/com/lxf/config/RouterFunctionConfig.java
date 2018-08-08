package com.lxf.config;

import com.lxf.model.User;
import com.lxf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Created by lixianfeng on 2018/7/25.
 */
@Configuration
public class RouterFunctionConfig {
    /**
     * Servlet
     * 请求接口:ServletRequest 或者 HttpServletRequest
     * 响应接口:ServletResponse 或者 HttpServletResponse
     *
     * Spring 5.0 重新定义了服务端请求与响应接口
     * 请求接口:ServletRequest
     * 响应接口:ServletResponse
     * 即可支持Servlet规范,也可支持自定义.比如Netty(Web Server) web容器
     *
     * 定义GET请求, 返回用户集合
     */

    @Bean
    @Autowired //(四中注入方式  构造注入,getset注入,定义式注入)
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),serverRequest -> {
            Collection<User> users = userRepository.findAllUser();
            Flux<User> userFlux = Flux.fromIterable(users);
            return  ServerResponse.ok().body(userFlux,User.class);
        });
    }
}
