package com.ssafy.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.SearchRequestDto;
import com.ssafy.board.model.dto.SearchResponseDto;
import com.ssafy.board.model.dto.SidoDto;
import com.ssafy.board.model.service.SearchService;

@RestController
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	private SearchService searchService;
	
	public MainController(SearchService searchService) {
		this.searchService = searchService;
	}

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/sido")
	public ResponseEntity<?> sido() throws Exception{
		List<SidoDto> sidoList = searchService.sidoList();
		if (sidoList != null && !sidoList.isEmpty()) {
			return new ResponseEntity<List<SidoDto>>(sidoList, HttpStatus.OK); // 200
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchResult(@RequestParam String sido, @RequestParam String category, @RequestParam String keyword) throws Exception {
		SearchRequestDto searchRequestDto = new SearchRequestDto(sido, category, keyword);
		List<SearchResponseDto> searchList = searchService.searchList(searchRequestDto);
		if (searchList != null && !searchList.isEmpty()) {
			return new ResponseEntity<List<SearchResponseDto>>(searchList, HttpStatus.OK); // 200
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
}
