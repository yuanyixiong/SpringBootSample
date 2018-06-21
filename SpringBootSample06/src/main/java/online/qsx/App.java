package online.qsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        /**
         * 静态文件优先级
         * src/main/resources/META-INF.resources
         * src/main/resources/resources
         * src/main/resources/static
         * src/main/resources/public
         *
         * css引用
         * <link rel="stylesheet" type="text/css" th:href="@{/css/main.css}" />
         */

        //实现文件上传
        SpringApplication.run(App.class, args);
        System.out.println("spring boot start success");
    }
}

