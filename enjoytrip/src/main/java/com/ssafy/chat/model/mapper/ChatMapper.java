package com.ssafy.chat.model.mapper;

import java.sql.SQLException;


import org.apache.ibatis.annotations.Mapper;

import com.ssafy.chat.model.dto.ChatDto;
@Mapper
public interface ChatMapper {
	
	public ChatDto chatSave(ChatDto chatDto) throws SQLException;
}
