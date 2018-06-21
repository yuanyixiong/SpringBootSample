package online.qsx.config.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor extends HandlerInterceptorAdapter {
    public DemoInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求进入开始记录时间");
        request.setAttribute("time",System.currentTimeMillis());
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求结束计算用时");
        String mess= String.format("请求耗时 %s",System.currentTimeMillis()-Long.valueOf(request.getAttribute("time").toString()));
        System.out.println(mess);
    }
}
