package testng;

import org.testng.annotations.Test;

// 异常测试
public class ExceptedException {
    //    因为期望是异常，但是实际没报异常，所以报错了
    @Test(expectedExceptions = RuntimeException.class)
    public void expectedExceptionFail() {
        System.out.println("这是一个测试会失败的异常");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void expectedExceptionSuccess() {
        System.out.println("这是一个会成功的异常");
        throw new RuntimeException();
    }
}
