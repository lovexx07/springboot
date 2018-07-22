package net.xdclass.demo2.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class CustomWebMvcConfigurer extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
////        registry.addInterceptor(new LoginFilter()).addPathPatterns("/api/");
//
//        super.addInterceptors(registry);
//    }
//}



@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LiginIntercepter()).addPathPatterns("/api2/*/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}