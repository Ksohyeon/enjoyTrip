package com.ssafy.place.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.place.model.dto.PlaceDto;
import com.ssafy.place.model.service.PlaceService;


@RestController
@RequestMapping("/place")
@CrossOrigin("*")
public class PlaceController {
	private final Logger logger = LoggerFactory.getLogger(PlaceController.class);

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

}
