package online.qsx.config.web;

import online.qsx.config.controller.MyMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitalizer implements WebApplicationInitializer {


    /**
     * spring 扩展 servlet3.0+ 版本的API接口,实现代替web.xml
     * spring 会自动扫描 WebApplicationInitializer的实现类
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);//注册配置类,并和ServletContext关联

        //注册spring mvc的Dispatcher Servlet
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        //http://localhost:8080/
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
