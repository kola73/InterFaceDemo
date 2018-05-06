package testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void dataProviderTest(String name, int age) {
        System.out.println("name=" + name + " age=" + age);
    }

    // 传值
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        Object[][] objects = new Object[][]{
                {"kola", 18},
                {"coco", 20},
        };
        return objects;
    }

    //    2,通过方法名进行参数化传递
    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("name=" + name + "age=" + age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("name=" + name + "age=" + age);
    }

    public Object[][] methodTest(Method method) {
        Object[][] objects = null;
        if (method.getName().equals("test1")) {
            objects = new Object[][]{
                    {"lucy", 18}
            };
        } else if (method.getName().equals("test2")) {
            objects = new Object[][]{
                    {"lily", 20}
            };
        }
        return objects;
    }
}