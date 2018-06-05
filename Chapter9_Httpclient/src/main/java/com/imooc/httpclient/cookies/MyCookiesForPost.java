package com.imooc.httpclient.cookies;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void getCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(this.url + uri);
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name=" + name + ",value=" + value);
        }

    }

    @Test(dependsOnMethods = {"getCookies"})
    public void postWithCookies() throws IOException {
//      声明一个client对象，用来进行方法的执行
        String uri = bundle.getString("test.post.with.cookies");
        DefaultHttpClient httpClient = new DefaultHttpClient();
//      声明一个方法，这个方法是post方法
        HttpPost post = new HttpPost(this.url + uri);
//      添加参数
        JSONObject param = new JSONObject();
        param.put("name", "huhansan");
        param.put("age", "18");
//      设置请求头信息
        post.setHeader("content-type", "application/json");
//      将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
//      声明一个对象来进行响应结果的存储
        String result;
//      设置cookies信息
        httpClient.setCookieStore(this.store);
//      执行post方法
        HttpResponse response = httpClient.execute(post);
//      获取响应结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
//      处理结果，判断返回结果是否符合预期
        System.out.println(result);
//      将返回的响应结果字符串转化成为json对象
        JSONObject resultJson = new JSONObject(result);
//      获取到结果值
        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
//      具体的判断返回结果的值
        Assert.assertEquals("success", success);
        Assert.assertEquals("1", status);

    }
}