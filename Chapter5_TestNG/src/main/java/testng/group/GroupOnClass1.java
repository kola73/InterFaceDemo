package testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass1 {
    public void stu1(){
        System.out.println("class 1");
    }
    public void stu2(){
        System.out.println("class 1");
    }
}
