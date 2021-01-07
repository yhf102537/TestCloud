package com.yhf.consumerfeign.client;

import com.yhf.common.base.Result;
import com.yhf.common.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ServiceFallback implements ServiceFeignClient{
    @Override
    public Result test(String par) {
        System.out.println("调用失败");
        return Result.msg("调用服务失败");
    }

    @Override
    public Result getUser(User user) {
        return Result.msg("调用服务失败");
    }

    @Override
    public Result getUser2(User user) {
        return Result.msg("调用服务失败");
    }
}
