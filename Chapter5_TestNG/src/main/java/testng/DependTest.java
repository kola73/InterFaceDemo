package testng;

import org.testng.annotations.Test;

/*依赖测试：本个测试方法依赖其他方法
适用场景：比如登录成功才能进行购物，但是登录不成功，就无法购物
如果被依赖的类失败的，运行程序就会报错，无法继续执行
 */
public class DependTest {
    @Test
    public void login() {
        System.out.println("登陆不成功");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"login"})
    public void buy() {
        System.out.println("购物失败");

    }
}
