package com.yhf.service01.controller;

import com.yhf.common.base.Result;
import com.yhf.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "service01/")
@Slf4j
public class Service01Controller {

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Result test(String par) {
        log.info("访问：/service01/test 参数：" + par);
        return Result.success(par);
    }

    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    public Result test(@RequestBody User user) {
        log.info("访问：/service01/getUser 参数：" + user);
        return Result.success(user);
    }

}
