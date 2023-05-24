package com.ssafy.chat.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.chat.model.dto.ChatDto;


public interface ChatService {
	public void chattingHandler(ChatDto chatDto) throws SQLException;

	public List<ChatDto> preChatList(String roomNo);
}
