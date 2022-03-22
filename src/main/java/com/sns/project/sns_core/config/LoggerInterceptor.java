package com.sns.project.sns_core.config;

import com.sns.project.sns_core.constant.PostApiConstant;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

public class LoggerInterceptor implements HandlerInterceptor {

    private Timestamp startTimestamp;
    private Timestamp endTimestamp;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTimestamp = new Timestamp(System.currentTimeMillis());
        boolean completedWithoutError = false;
        return completedWithoutError;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        endTimestamp = new Timestamp(System.currentTimeMillis());
    }
}
