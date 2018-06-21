package online.qsx.controller;

import online.qsx.model.AutoAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * spring boot ioc
 */
@SpringBootApplication
@Controller
@RequestMapping(value = "hello")
public class HelloController {

    //自定义Bean注入
    @Autowired
    private AutoAuthor autoAuthor;

    @GetMapping(value = "index")
    public @ResponseBody
    String index() {
        //输出注入的自定义对象
        System.out.println(autoAuthor);
        return "succeed";
    }

    /**
     * 实现自动配置案例
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
        System.out.println("spring boot start succeed");
    }


    
    public void a(){}
}
