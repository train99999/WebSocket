package com.quan.websocket1.controller;


import com.quan.websocket1.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    //这方法用来处理浏览器发过来的消息
//    @MessageMapping("/hello")
    //把消息转发到 /topic/greetings 交给配置好的 WebSocketConfig代理，让他广播到所有连接上来的客户端
//    @SendTo("/topic/greetings")
//    public Message greeting(Message message){
//        return message;
//    }

    //这方法用来处理浏览器发过来的消息
    @MessageMapping("/hello")
    public void greeting(Message message){
        System.out.println(message);
        // 把消息转发到 /topic/greetings
        simpMessagingTemplate.convertAndSend("/topic/greetings",message);
    }
}
