package com.ssafy.qna.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.qna.model.dto.QnaDto;
import com.ssafy.qna.model.service.QnaService;

@RestController
@RequestMapping("/qna")
@CrossOrigin("*")
public class QnaController {
	
	private final Logger logger = LoggerFactory.getLogger(QnaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	@Autowired
	private QnaService qnaService;
	
	public QnaController(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	
	@GetMapping
	public ResponseEntity<?> listQna() throws Exception{
		List<QnaDto> list = qnaService.listQna();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<QnaDto>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<?> getQna(@PathVariable("no") String no) throws Exception{
		QnaDto qnaDto = qnaService.getQna(no);
		if (qnaDto != null) {
			return new ResponseEntity<QnaDto>(qnaDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@PostMapping
	public ResponseEntity<String> writeQna(@RequestBody Map<String, String> map) throws Exception{
		System.out.println(map);
		QnaDto qnaDto = new QnaDto(map.get("title"), map.get("content"), map.get("category"), map.get("userId"));
		System.out.println(qnaDto);
		if (qnaService.createQna(qnaDto) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
