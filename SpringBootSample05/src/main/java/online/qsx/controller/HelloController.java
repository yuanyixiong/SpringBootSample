package online.qsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//http://localhost:8080/hellocontroller
@Controller
@RequestMapping(value = "hellocontroller")
public class HelloController {

    //http://localhost:8080/hellocontroller/index
    @GetMapping(value = "index")
    public ModelAndView to_index(ModelAndView modelAndView) {
        System.out.println("index");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
