package testng.group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClass3 {
    public void stu1() {
        System.out.println("class 3");
    }

    public void stu2() {
        System.out.println("class 3");
    }
}