package com.yhf.service02.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Slf4j
public class WebConfig extends WebMvcConfigurationSupport {

    //配置静态资源
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("继承WebMvcConfigurationSupport 配置静态资源，注：解决访问404问题");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }


}
