package com.yhf.consumerribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yhf.common.base.Result;
import com.yhf.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping(value = "/restTemplateToService01Test")
    @HystrixCommand(fallbackMethod = "testFallback")
    public Result restTemplateToService01Test(@RequestParam("par") String par) {
        System.out.println("通过restTemplate访问Service01的test 参数："+par);
        MultiValueMap map = new LinkedMultiValueMap();//普通参数必须使用此map传递
        map.add("par",par);
        //url:http:// + app.name + root_path + 具体接口地址
        Result result = this.restTemplate.postForObject("http://Service01/Service01/service01/test",map,Result.class);
        return result;
    }

    public Result testFallback(String par) {
        return Result.msg("访问失败");
    }

    @PostMapping(value = "/restTemplateToService01ToGetUser")
    @HystrixCommand(fallbackMethod = "getUserFallback")
    public Result restTemplateToService01ToGetUser(@RequestBody User user) {
        System.out.println("通过restTemplate访问Service01的getUser 参数："+user);
        Result result = this.restTemplate.postForObject("http://Service01/Service01/service01/getUser",user,Result.class);
        return result;
    }

    public Result getUserFallback(@RequestBody User user) {
        return Result.msg("访问失败");
    }

}
