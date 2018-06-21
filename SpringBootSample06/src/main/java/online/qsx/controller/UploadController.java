package online.qsx.controller;

import online.qsx.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//http://localhost:8080/uploadController
@Controller
@RequestMapping(value = "uploadController")
public class UploadController {

    //进入：//http://localhost:8080/to_upload
    //http://localhost:8080/uploadController/do_upload
    @PostMapping(value = "do_upload")
    @ResponseBody
    public String do_upload(MultipartFile file){
        if(file!=null) {
            System.out.println(file.getName());
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getContentType());
            return  "success";
        }
        return "error";
    }

}
