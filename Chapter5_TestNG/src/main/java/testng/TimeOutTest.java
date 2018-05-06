package testng;

import org.testng.annotations.Test;

/*超时测试
* 适用于等一段时间就不想等，直接跳到下一个case的情况
 */
public class TimeOutTest {
    //    期望在3s得到结果，结果2s就成功了，所以测试结果是通过
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    //    期望2s得到结果，但是3s才得到结果，所以失败了
    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
