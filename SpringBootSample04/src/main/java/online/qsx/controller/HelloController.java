package online.qsx.controller;

import online.qsx.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.RespectBinding;

//http://localhost:8080/hellocontroller
@Controller
@RequestMapping(value = "hellocontroller")
public class HelloController {

    //http://localhost:8080/hellocontroller/hello
    @GetMapping(value = "hello")
    @ResponseBody
    public User hello() {
        System.out.println("hello");
        return new User(1L, "arvin", 15, '男');
    }

    //http://localhost:8080/hellocontroller/index
    @GetMapping(value = "index")
    public ModelAndView to_index(ModelAndView modelAndView) {
        System.out.println("index");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
