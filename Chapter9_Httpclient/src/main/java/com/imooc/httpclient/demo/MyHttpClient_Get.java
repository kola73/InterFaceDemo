package com.imooc.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

//get请求的实现
public class MyHttpClient_Get {
    @Test
    public void getTest() throws IOException {
//        用来存放结果
        String result;
//        创建get方法
        HttpGet get = new HttpGet("http://localhost:8888/getCookies");
//        执行get方法
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(get);
//        获取整个响应的全部内容，并把它转化为字符串(为了防止乱码，加上编码格式utf-8
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

    }
}
