package com.imooc.bean;

import lombok.Data;

//加上@data注解后getter，setter等常用方法都不用写了
@Data
public class User {
    private String name;
    private String sex;
    private String age;
    private String userName;
    private String password;
}
