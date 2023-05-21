package com.ssafy.place.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ssafy.place.model.dto.PlaceDto;
import com.ssafy.place.model.service.PlaceService;
import com.ssafy.qna.model.dto.QnaDto;


@RestController
@RequestMapping("/place")
@CrossOrigin("*")
public class PlaceController {
	private final Logger logger = LoggerFactory.getLogger(PlaceController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private PlaceService placeService;

	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}

	@GetMapping
	public ResponseEntity<?> place() throws Exception {
		List<PlaceDto> placeList = placeService.placeList();
		if (placeList != null && !placeList.isEmpty()) {
			return new ResponseEntity<List<PlaceDto>>(placeList, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<?> getQna(@PathVariable("no") String no) throws Exception{
		PlaceDto placeDto = placeService.getPlace(no);
		if(placeDto != null) {
			return new ResponseEntity<PlaceDto>(placeDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@PostMapping
	public ResponseEntity<String> WritePlace(@RequestBody Map<String, String> map) throws Exception{
		PlaceDto placeDto = new PlaceDto(map.get("lat"),map.get("lon"),map.get("title"),map.get("content"),map.get("date"),map.get("image"));
		if(placeService.createPlace(placeDto) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{no}")
	public ResponseEntity<?> modifyPlace(@PathVariable("no") String no, @RequestBody PlaceDto placeDto) throws Exception {
		placeDto.setNo(no);
		System.out.println(placeDto);
		if (placeService.updatePlace(placeDto) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{no}")
	public ResponseEntity<?> deletePlace(@PathVariable("no") String no) throws Exception{
		if (placeService.deletePlace(no) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
