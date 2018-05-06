package testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {

    public void stu1() {
        System.out.println("class 2");
    }

    public void stu2() {
        System.out.println("class 2");
    }
}

