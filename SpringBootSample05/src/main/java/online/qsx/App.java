package online.qsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //拦截器
        SpringApplication.run(App.class, args);
        System.out.println("spring boot start success");
    }
}

