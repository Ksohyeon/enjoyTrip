package com.ssafy.chat.controller;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.chat.model.dto.ChatDto;
import com.ssafy.chat.model.service.ChatService;
@Controller
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {
	private ChatService chatService;

	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@MessageMapping("/receive")
	@SendTo("/send")
	public ChatDto chatHandler(ChatDto chatDto) throws Exception {
		return chatService.chattingHandler(chatDto);
	}
	
}
