package online.qsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

        //该案例为使用springboot 自定义搭建spring mvc框架
        //实现基础的同步访问
        //实现基础的异步访问
        SpringApplication.run(App.class,args);
        System.out.println("spring boot start success");
    }
}
