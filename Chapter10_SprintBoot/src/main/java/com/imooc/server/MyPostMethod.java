package com.imooc.server;

import com.imooc.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//用户登陆成功获取到cookies，然后再访问其他接口获取到列表

@RestController
@Api(value = "/", description = "这是我的POST请求")
@RequestMapping(value = "/v1")
public class MyPostMethod {
    //这个变量是用来装我们cookies信息的
    private static Cookie cookie;

    // 获取cookies
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "login", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("kola") && password.equals("1234")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你成功获取cookies！";
        }
        return "用户名或密码错误！";
    }

    //获取列表
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User user) {
//        获取所有cookies
        User user1;
//        验证cookies是否合法
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName() == "login" && cookie.getValue() == "true"
                    && user.getAge() == "18" && user.getSex() == "man" && user.getName() == "kola") {
                user1 = new User();
                user1.setSex("man");
                user1.setAge("18");
                user1.setName("lisi");
                return user1.toString();
            }
        }
        return "参数不合法";
    }
}
