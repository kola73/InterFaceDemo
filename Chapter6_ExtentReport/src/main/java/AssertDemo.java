import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertDemo {
    @Test
    public void test1() {
        Assert.assertEquals(111, 222);
    }

    @Test
    public void test2() {
        Assert.assertEquals(111, 111);
    }

    @Test
    public void test3() {
        Assert.assertEquals("aaa", "bbb");
    }

    @Test
    public void log() {
        Reporter.log("这是我自己写的log啦");
        throw new RuntimeException("自己写异常好无聊哈哈哈");
    }
}