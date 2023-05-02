package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.SearchRequestDto;
import com.ssafy.board.model.dto.SearchResponseDto;
import com.ssafy.board.model.dto.SidoDto;
import com.ssafy.board.model.mapper.SearchMapper;
@Service
public class SearchServiceImpl implements SearchService{

	private SearchMapper searchMapper;
	
	@Autowired
	public SearchServiceImpl(SearchMapper searchMapper) {
		this.searchMapper = searchMapper;
	}

	@Override
	public List<SidoDto> sidoList() throws Exception {
		return searchMapper.sidoList();
	}

	@Override
	public List<SearchResponseDto> searchList(SearchRequestDto searchRequestDto) throws Exception {
		return searchMapper.searchList(searchRequestDto);
	}
	

}
