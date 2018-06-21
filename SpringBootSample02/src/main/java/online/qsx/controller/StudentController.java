package online.qsx.controller;

import online.qsx.model.Student;
import online.qsx.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private @Autowired StudentServer studentServer;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public @ResponseBody List<Student>  queryList(){
        System.out.println("Hello");
        return studentServer.getStudents(null);
    }

    @RequestMapping(value = "index",method =RequestMethod.GET)
    public ModelAndView to_html(ModelAndView mav){
        System.out.println("to_html");
        mav.setViewName("hello");
        return mav;
    }
}
