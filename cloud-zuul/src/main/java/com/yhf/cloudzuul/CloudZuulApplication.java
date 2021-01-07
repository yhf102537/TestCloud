package com.yhf.cloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CloudZuulApplication {

    //通过zull访问Service01
    //===>http://localhost:6060      /sbService           /Service01         /service01/test
    //        网管地址           根据项目名路由地址     所转发项目根路径       接口路径

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

}
