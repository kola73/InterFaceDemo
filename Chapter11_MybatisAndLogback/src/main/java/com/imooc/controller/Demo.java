package com.imooc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//进行增删改查操作 api的value跟requestmapping里面对应，因为Api是它的说明
@Log4j2
@RestController
@Api(value = "v1", description = "这是我第一个版本的demo")
@RequestMapping(value = "v1")
public class Demo {
    //    获取执行sql语句的对象(autowired 自动加载）
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数", httpMethod = "GET")
    public Object getUserCount() {
        return template.selectOne("getUserCount");

    }
}
