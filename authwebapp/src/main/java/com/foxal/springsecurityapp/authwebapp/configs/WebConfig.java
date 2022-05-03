package com.foxal.springsecurityapp.authwebapp.configs;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                        "/img/**",
                        "/css/**"
                    )
                .addResourceLocations(
                        "classpath:/static/img/",
                        "classpath:/static/css/"
                );
    }
}
