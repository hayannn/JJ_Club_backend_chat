package com.jjclub.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//해당 코드는 외부 도메인 연결 시도에 사용되는 코드입니다. 반드시 작성할 필요는 없습니다.
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/chat")
            .allowedOrigins("http://chat.jjclub.pe.kr", "ws://chat.jjclub.pe.kr")
            .allowedHeaders("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowCredentials(true)
            .maxAge(3600);
    }
}
