package com.imooc.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

//    @RestController表示告诉前面这个是需要被扫描的类
@RestController
public class MyGetMethod {
    //    指定访问的路径和请求的方法
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
//    HttpServletResponse不是参数，是装请求信息的类，把响应信息写在里面，会返回给页面
    public String getCookies(HttpServletResponse response) {
//    HttpServerletRequest 装请求信息的类
//    HttpServerletResponse  装响应信息的类
//        获取cookies
        Cookie cookie = new Cookie("login", "true");
//        添加cookies
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }
}