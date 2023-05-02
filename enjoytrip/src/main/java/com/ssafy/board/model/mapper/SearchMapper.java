package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.SearchRequestDto;
import com.ssafy.board.model.dto.SearchResponseDto;
import com.ssafy.board.model.dto.SidoDto;

@Mapper
public interface SearchMapper {
	public List<SidoDto> sidoList() throws SQLException;
	public List<SearchResponseDto> searchList(SearchRequestDto searchRequestDto) throws SQLException;

}
