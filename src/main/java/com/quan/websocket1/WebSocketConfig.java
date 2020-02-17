package com.quan.websocket1;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    // 配置消息代理
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 如果发的消息的前缀是 topic 的话，这消息就会转发给消息代理
        registry.enableSimpleBroker("/topic");
        // 把 /app 开头的请求交给代理来处理
        registry.setApplicationDestinationPrefixes("/app");
    }

    // 注册连接点
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }
}
