package hello;
//入口类
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 表示被springboot托管了
@SpringBootApplication
// 指定要扫描哪个包下的类
@ComponentScan("com.imooc.server")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
