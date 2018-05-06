package testng.suite;

import org.testng.annotations.*;

public class Suite {
    @BeforeSuite
    public void beforeSuit() {
        System.out.println("这是beforesuite");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("这是aftersuite");
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