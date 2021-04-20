package edu.tyut.wrx.brain.config;

import edu.tyut.wrx.brain.filter.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BrainGlobalConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter())
                .addPathPatterns("/**")
                .excludePathPatterns("/organization/login")
                .excludePathPatterns("/user/addUser");
    }
}
