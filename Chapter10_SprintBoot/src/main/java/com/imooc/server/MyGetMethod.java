package com.imooc.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/*
给客户端返回cookies
 */
//    @RestController表示告诉前面这个是需要被扫描的类
@RestController
public class MyGetMethod {
    //    指定访问的路径和请求的方法
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
//    HttpServletResponse不是参数，是装请求信息的类，把响应信息写在里面，会返回给页面
    public String getCookies(HttpServletResponse response) {
//    HttpServerletRequest 装请求信息的类
//    HttpServerletResponse  装响应信息的类
//        设置cookies
        Cookie cookie = new Cookie("login", "true");
//        添加cookies
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /*
    要求客户端携带cookies访问
    一个携带cookies信息才能访问的请求
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {
//        获取cookies
        Cookie[] cookies = request.getCookies();
//        判断是否为空，为空则报错
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息来";
        }
//        循环遍历cookies，如果符合，则返回正确提示，否则返回错误提示
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }
        return "你必须携带cookies信息来";
    }
}