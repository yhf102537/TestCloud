package com.yhf.consumerfeign.controller;

import com.yhf.common.base.Result;
import com.yhf.common.entity.User;
import com.yhf.consumerfeign.client.ServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/feign")
public class ServiceController {

    @Autowired
    ServiceFeignClient serviceFeignClient;

//    @RequestMapping(value = "/byFeginToService01-test", method = RequestMethod.POST)
    @PostMapping(value = "/byFeginToService01-test")
    public Result byFeginToService01(String par) {
        System.out.println("通过feign访问Service01的test 参数："+par);
        Result result = serviceFeignClient.test(par);
        return result;
    }

    @PostMapping(value = "/byFeginToService01ToGetUser1")
    public Result byFeginToService01ToGetUser1(@RequestBody User user) {
        System.out.println("通过feign访问Service01的getUser1 参数："+user);
        Result result = serviceFeignClient.getUser(user);
        return result;
    }

    @PostMapping(value = "/byFeginToService01ToGetUser2")
    public Result byFeginToService01ToGetUser2(@RequestBody User user) {
        System.out.println("通过feign访问Service01的getUser2 参数："+user);
        Result result = serviceFeignClient.getUser2(user);
        return result;
    }

}
