package com.yhf.service02.controller;

import com.yhf.common.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
@RequestMapping("/service02")
@Slf4j
public class Service02Controller {


    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Result test(String par) {
        log.info("访问：/service02/test");
        return Result.success(par);
    }

}
