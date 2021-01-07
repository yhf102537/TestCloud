package com.yhf.service01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public Docket createRestApi() {
        log.info("createRestApi，设置项目路径：com.yhf.service01，访问路径：http://localhost:8061/Service01/swagger-ui.html");
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("TOKEN").description("令牌-token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yhf.service01"))//设置项目路径
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //只显示加了注解的api
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("service01-在线文档")
                .description("接口文档")
                .termsOfServiceUrl("http://www.baidu.com/")
                .version("1.0")
                .build();
    }


}
