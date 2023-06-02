package com.jjclub.chat.config;

import com.jjclub.chat.handler.ChatWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//해당 코드는 웹소켓을 열고, 연결하기 위해 반드시 필요한 코드입니다.
@Configuration
@EnableWebSocket
@CrossOrigin({"http://chat.jjclub.pe.kr", "ws://chat.jjclub.pe.kr"}) //해당 부분은 외부 도메인을 허용하는 코드로, 로컬호스트 테스트 시에는 삭제해도 됩니다.
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new ChatWebSocketHandler(), "/api/v1/chat")
            .setAllowedOrigins("*");
    }
}
