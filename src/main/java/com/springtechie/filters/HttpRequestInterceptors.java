package com.springtechie.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Component
public class HttpRequestInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // validations
        // validations are success goes to control class else rerun false
        String requestURI = request.getRequestURI();
        // /get/employee/id/1
        // split based on /
        //
        if(requestURI.contains("/get/employee/id")) {
            String[] split = requestURI.split("/");
            int id = Integer.valueOf(split[split.length-1]);
            System.out.println(id);
            if(id>1) {
                return true;
            }
            return false;


        }
        System.out.println("I am a prehandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
       // if you handle any response object.
        System.out.println("I am a posthandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // once the response reaches to client.
        System.out.println("I am a afterCompletion");
    }
}
