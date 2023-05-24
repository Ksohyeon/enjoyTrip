package com.ssafy.chat.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.chat.model.dto.ChatDto;
import com.ssafy.chat.model.service.ChatService;
import com.ssafy.member.model.service.MemberService;
@Controller
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {
	
	private ChatService chatService;
	private MemberService memberService;
	
	


	public ChatController(ChatService chatService, MemberService memberService) {
		super();
		this.chatService = chatService;
		this.memberService = memberService;
	}

	@MessageMapping("/receive/{roomno}")
	@SendTo("/send/{roomno}")
	public ChatDto chatHandler(@PathVariable String roomno, ChatDto chatDto) throws Exception {
		chatService.chattingHandler(chatDto);
		chatDto.setUserNickName(memberService.getNickName(chatDto.getUserId()));
		System.out.println(chatDto);
		return chatDto;
	}
	
	@GetMapping("/{roomNo}")
	public ResponseEntity<?> preChatList(@PathVariable String roomNo) throws Exception {
		List<ChatDto> list = chatService.preChatList(roomNo);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<ChatDto>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
}
