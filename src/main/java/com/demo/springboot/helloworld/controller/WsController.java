package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.messageNotification.RequestMessage;
import com.demo.springboot.helloworld.common.messageNotification.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
    @MessageMapping("/system")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("From System:" + message.getName());
    }
}
