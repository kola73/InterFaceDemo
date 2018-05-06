package testng.multiThread;

import org.testng.annotations.Test;
/*多线程测试：
实际工作中注意不要有跨线程的变量去关联，试用于各不相干的代码。
不推荐用多线程用性能测试
这个主要是适用于多线程执行没什么关联的case
 */

public class MultiThreadOnMethod {
    //    打印10次1
    @Test(invocationCount = 10)
    public void test1() {
        System.out.println("1");
    }

    /*
    1,如果我们不加第二个参数threadpoolsize（线程池数），name就只能对一个线程池进行操作
    2,Thread.currentThread():一个thread就是一个线程，当你编程使用多线程的时候，用currentthread（）这个method来获取
    3,当前运行线程，以便对其进行操作
    4,%s%n:格式化,就是用固定的数据类型的某个值，替换字符串当中的一个位置,每个语言当中表现形式不太一样。
    比如%s 一般表示字符串。如果有用到这种，每次都要用printf打印
    */

    @Test(invocationCount = 5, threadPoolSize = 5)
    public void test2() {
        System.out.printf("thread id=%s%n", Thread.currentThread().getId());
    }
}
