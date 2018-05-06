package testng;

import org.testng.annotations.*;

public class TestNG_Demo {
    @Test
    public void test1(){
        System.out.println("这是test1");
    }
    @Test
    public void test2(){
        System.out.println("这是test2");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeclass在类执行前执行");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("beforeclass在类执行后执行");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforemethod在test后执行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterclass在test前执行");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforesuite在beforeclass后执行");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("aftersuite在afterclass后执行");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforetest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("aftertest");
    }
}
