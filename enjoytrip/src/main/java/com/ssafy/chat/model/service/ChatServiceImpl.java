package com.ssafy.chat.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.chat.model.dto.ChatDto;
import com.ssafy.chat.model.mapper.ChatMapper;
@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private final ChatMapper chatMapper;
	
	public ChatServiceImpl(ChatMapper chatMapper) {
		super();
		this.chatMapper = chatMapper;
	}

	@Override
	public ChatDto chattingHandler(ChatDto chatDto) throws SQLException {
		
		
		return chatMapper.chatSave(chatDto);
	}

}
