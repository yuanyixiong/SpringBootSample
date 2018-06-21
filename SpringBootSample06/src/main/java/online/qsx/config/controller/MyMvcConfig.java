package online.qsx.config.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value = "online.qsx.controller")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 注入视图解析器
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver createViewResolver() {
        System.out.println("createViewResolver");

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //返回的路径,该路径需要设置springmvc实现暴露
        //,WebMvcConfigurerAdapter 的 addResourceHandlers 可以实现路劲下的资源暴露
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");//返回的文件后缀
        //viewResolver.setViewClass(JstlView.class); //设置视图类型为jsp/默认视图类型为html
        return viewResolver;
    }

    /**
     * 配置视图解析器的资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //WebMvcConfigurerAdapter 下的方法为配置springmvc使用的
        //WebMvcConfigurerAdapter下的方法默认不生效,继承WebMvcConfigurerAdapter的类配置了@EnableWebMvc才会生效

        //addResourceHandler 对外暴露访问路径
        //addResourceLocations 指定文件位置
        //http;//localhost:8080/templates/index.html
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");//界面的位置
        //http;//localhost:8080/static/css/upload.css
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");//静态资源的位置
    }
    /**
     * 指定url地址直接映射到页面,简化Controoler中跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //localhost:8080/to_upload === /templates/upload.html
        registry.addViewController("/to_upload").setViewName("/upload");
    }

    /**
     * 注入文件上传组件
     * @return
     */
    @Bean
    @Qualifier(value = "multipartResolver")
    public CommonsMultipartResolver createCommonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");//默认编码
        commonsMultipartResolver.setMaxUploadSize(10485760000L);//文件大小最大值
        commonsMultipartResolver.setMaxInMemorySize(40960);///内存中的最大值
        return  commonsMultipartResolver;
    }
}
