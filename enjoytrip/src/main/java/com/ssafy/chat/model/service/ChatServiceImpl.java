package com.ssafy.chat.model.service;

import java.sql.SQLException;
import java.util.List;

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
	public void chattingHandler(ChatDto chatDto) throws SQLException {
		chatMapper.chatSave(chatDto);
	}

	@Override
	public List<ChatDto> preChatList(String roomNo) {
		return chatMapper.preChatList(roomNo);
	}

}
