package testng.suite;

import org.testng.annotations.Test;

//忽略测试:在@Test后面加上个框，里面写enabled=false
public class IgnoreTest {
    @Test(enabled = false)
    public void ignore() {
        System.out.println("ignore不执行");
    }
}
