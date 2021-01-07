package com.yhf.consumerfeign.client;

import com.yhf.common.base.Result;
import com.yhf.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "Service01", path = "/Service01/",fallback=ServiceFallback.class) //这里的value对应所调用服务的spring.applicatoin.name
public interface ServiceFeignClient {

    @RequestMapping(value = "/service01/test", method = RequestMethod.POST)
    Result test(@RequestParam("par") String par);//一般参数：一定要给参数加@RequestParam("par")注解 否者服务端获取不到

    @PostMapping(value = "/service01/getUser")
    Result getUser(@RequestBody User user);//对象参数：写法1要加@RequestBody注解

    @PostMapping(value = "/service01/getUser",consumes = "application/json")
    Result getUser2(User user);//对象参数：写法2要加参数：consumes = "application/json"

}
