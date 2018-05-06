package testng;

import org.testng.annotations.Test;

public class BasicAnnotation {
    @Test 
    public void testcase(){
        System.out.println("这个@test测试标签");
    }
}
