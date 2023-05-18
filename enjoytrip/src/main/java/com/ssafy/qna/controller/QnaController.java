package com.ssafy.qna.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.qna.model.dto.QnaDto;
import com.ssafy.qna.model.dto.SearchCondition;
import com.ssafy.qna.model.service.QnaService;

@RestController
@RequestMapping("/qnaapi")
@CrossOrigin("*")
public class QnaController {

	private QnaService qnaService;

	public QnaController(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	
	// 추가 (POST /qna)
	@PostMapping("/qna")
	public ResponseEntity<?> insert(@RequestBody QnaDto qna) throws Exception {
		int result = qnaService.insert(qna);
		if (result > 0) {
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);  // 201
		}
		else {
			throw new Exception();
		}
	}
	
	// qna 하나 선택 (GET /qna/{qnano})
	@GetMapping("/qna/{qnano}")
	public ResponseEntity<?> select(@PathVariable String qnano) throws Exception {
		QnaDto qna = qnaService.select(qnano);
		if (qna != null) {
			return new ResponseEntity<QnaDto>(qna, HttpStatus.OK);  // 200
		}
		else {
			return new ResponseEntity<QnaDto>(qna, HttpStatus.NO_CONTENT);  // 204
		}
	}
	
	// qna 하나 수정 (PUT /qna/{qnano})
	@PutMapping("/qna/{qnano}")
	public ResponseEntity<?> update(@PathVariable String qnano, @RequestBody QnaDto qna) throws Exception{
		int cnt = qnaService.update(qna);
		if (cnt > 0) {
			return new ResponseEntity<QnaDto>(qna, HttpStatus.OK);  // 200
		}
		else {
			throw new Exception();
		}
	}
	
	// qna 하나 삭제 (DELETE /qna/{qnano})
	@DeleteMapping("/qna/{qnano}")
	public ResponseEntity<?> delete(@PathVariable String qnano) throws Exception {
		int cnt = qnaService.delete(qnano);
		if (cnt > 0) {
			return new ResponseEntity<String>(qnano, HttpStatus.OK);  // 200
		}
		else {
			throw new Exception();
		}
	}
	
	// Qna 목록 (GET /qna)
	@GetMapping("/qna")
	public ResponseEntity<?> search(SearchCondition condition) throws Exception{
		List<QnaDto> qnas = qnaService.search(condition);
		if (qnas != null && !qnas.isEmpty()) {
			for (QnaDto dto : qnas) {
				System.out.println(dto.toString());
			}
			return new ResponseEntity<List<QnaDto>>(qnas, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		}
	}
	
}
