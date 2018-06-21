package online.qsx.controller;

import online.qsx.model.Users;
import online.qsx.server.UsersServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wangwei on 2016/9/2.
 */
//@Controller
@RestController
public class UsersController {

    @Autowired
    @Qualifier("usersServerImpl")
    UsersServer usersServer;

    //json
    @ResponseBody
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @RequestMapping(value = "index_proscenium", method = RequestMethod.GET)
    public ModelAndView index_proscenium(ModelAndView mav) {
        mav.setViewName("proscenium/index");
        return mav;
    }

    @RequestMapping(value = "index_background", method = RequestMethod.GET)
    public ModelAndView index_background(ModelAndView mav) {
        mav.setViewName("background/index");
        return mav;
    }

    //queryUsers_json?id=2
    @ResponseBody
    @RequestMapping(value = "queryUsers_json", method = RequestMethod.GET)
    public Users queryUsers(Users users) {
        return usersServer.getUsers(users);
    }

    //queryUsers_index?id=2
    @RequestMapping(value = "queryUsers_index", method = RequestMethod.GET)
    public ModelAndView queryUsers(Users users, ModelAndView mav) {
        mav.addObject("users", usersServer.getUsers(users));
        mav.setViewName("index");
        return mav;
    }

    //error
    @RequestMapping(value = "queryUseries_index", method = RequestMethod.GET)
    public ModelAndView queryUseries(Users users, ModelAndView mav) {
        mav.addObject("useries", usersServer.getUseries(users));
        mav.setViewName("index");
        return mav;
    }

    //error code
    @RequestMapping(value = "returnJson", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public List<Users> returnJson(Users users, ModelAndView mav) {
        return usersServer.getUseries(users);
    }

    // error code
    @RequestMapping(value = "returnXml", method = RequestMethod.GET,produces = "application/xml;charset=UTF-8")
    public List<Users> returnXml(Users users, ModelAndView mav) {
        return usersServer.getUseries(users);
    }

    // error code
    @RequestMapping(value = "returnText", method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public List<Users> returnText(Users users, ModelAndView mav) {
        return usersServer.getUseries(users);
    }

}
