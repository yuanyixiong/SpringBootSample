package online.qsx.config.controller;


import online.qsx.config.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value = "online.qsx.controller")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 注入视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver createViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        //返回的路径,该路径需要设置springmvc实现暴露
        //,WebMvcConfigurerAdapter 的 addResourceHandlers 可以实现路劲下的资源暴露
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");//返回的文件后缀
        //viewResolver.setViewClass(JstlView.class); //设置视图类型为jsp/默认视图类型为html
        return  viewResolver;
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
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

    /**
     * 注入拦截器
     * @return
     */
    @Bean
    public HandlerInterceptorAdapter createInterceptor(){
        return  new DemoInterceptor();
    }

    /**
     * 添加拦截器到spring mvc
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createInterceptor());
    }
}
