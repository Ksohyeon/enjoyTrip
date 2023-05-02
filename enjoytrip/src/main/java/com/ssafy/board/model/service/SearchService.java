package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.SearchRequestDto;
import com.ssafy.board.model.dto.SearchResponseDto;
import com.ssafy.board.model.dto.SidoDto;


public interface SearchService {

	List<SidoDto> sidoList() throws Exception;
	List<SearchResponseDto> searchList(SearchRequestDto searchRequestDto) throws Exception;

}
