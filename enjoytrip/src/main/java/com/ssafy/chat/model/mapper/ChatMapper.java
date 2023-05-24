package com.ssafy.chat.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.chat.model.dto.ChatDto;
@Mapper
public interface ChatMapper {
	
	public void chatSave(ChatDto chatDto) throws SQLException;

	public List<ChatDto> preChatList(String roomNo);
}
