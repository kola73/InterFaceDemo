import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//启动项
@SpringBootApplication
//表示要扫描的包的名称
@ComponentScan("com.imooc")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
