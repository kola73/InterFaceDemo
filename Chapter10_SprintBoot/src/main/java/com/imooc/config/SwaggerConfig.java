package com.imooc.config;

//配置文件（这些做完以后页面就有了，可以启动springboot后进行访问：http://localhost:9999/swagger-ui.html）
/*
配置swaggerui
1，导入2个jar包
2，配置文件(config目录下)
3，给swagger加方法(在原来方法基础上加上ApiOperation等：  @ApiOperation(value = "通过这个方法可以获取cookies", httpMethod = "GET"))
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//加载配置文件专门标签: @Configuration。加载这2个以后，后续会自动加载为配置文件
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
//    Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容器。
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                配置访问路径并选择它
                .pathMapping("/")
                .select()
//              路径（/.* ：匹配server里面的内容）
                .paths(PathSelectors.regex("/.*"))
                .build();


    }

    private ApiInfo apiInfo() {
//        title里面写的是生成的文档的title
        return new ApiInfoBuilder().title("我的接口文档")
                .contact(new Contact("kola", "", "282156710@qq.com"))
                .description("这是我的swaggerui生成的接口文档")
//                一般版本号都是4位
                .version("1.0.0.0")
                .build();
    }
}

