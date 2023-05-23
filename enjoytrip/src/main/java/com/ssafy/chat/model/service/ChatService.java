package com.ssafy.chat.model.service;

import java.sql.SQLException;

import com.ssafy.chat.model.dto.ChatDto;




public interface ChatService {
	public ChatDto chattingHandler(ChatDto chatDto) throws SQLException;
}
