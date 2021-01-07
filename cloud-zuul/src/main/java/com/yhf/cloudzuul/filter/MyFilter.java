package com.yhf.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";// 定义filter的类型，有pre、route、post、error四种
    }

    @Override
    public int filterOrder() {
        return 0;// 定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true; // 表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public Object run() throws ZuulException {
        // filter需要执行的具体操作
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("访问路径：" + request.getPathInfo() + request.getServletPath());
        log.info("参数：" + request.getParameterMap().toString());
        return null;
    }
}
