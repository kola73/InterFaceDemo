package testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
    @Test
    @Parameters({"name", "age"})
    public void paramterTest(String name, int age) {
        System.out.println("name=" + name + " age=" + age);
    }
}

