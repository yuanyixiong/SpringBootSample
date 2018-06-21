package online.qsx;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Hello world!
 *
 */
@Controller
@SpringBootApplication
public class App {

	@RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring boot!";
    }

    public static void main( String[] args ){
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }
}
