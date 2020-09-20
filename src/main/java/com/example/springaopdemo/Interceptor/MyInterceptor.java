package com.example.springaopdemo.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lucas
 * @date 2020/9/20 16:06
 * 创建自己的拦截器，通过实现HandlerInterceptor接口，重写接口的三个方法，
 * preHandle()，预处理回调方法，实现处理器的预处理，如：登录检查，都是在请求controller层之前执行，
 * postHandle()，后处理回调方法，实现处理器的后处理，但是要在渲染视图之前
 * afterCompletion()，整个请求处理完毕回调方法，要在整个视图渲染完毕后回调
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("---------------preHandle---------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("---------------postHandle---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("---------------afterCompletion---------------");
    }
}
