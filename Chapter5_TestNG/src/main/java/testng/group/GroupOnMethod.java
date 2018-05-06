package testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups = "server")
    public void test1() {
        System.out.println("这是第一个case");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("这是第二个case");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("这是第三个case");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("这是第四个case");
    }
    @BeforeGroups(groups = "server")
    public void beforeGroups(){
        System.out.println("这是beforegroups");
    }
    @AfterGroups(groups = "client")
    public void afterGroups(){
        System.out.println("这是aftergroups");
    }
}
