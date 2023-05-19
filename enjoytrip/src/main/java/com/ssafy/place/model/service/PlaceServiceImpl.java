package com.ssafy.place.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.place.model.dto.PlaceDto;
import com.ssafy.place.model.mapper.PlaceMapper;
@Service
public class PlaceServiceImpl implements PlaceService{
	
	private PlaceMapper placeMapper;
	
	@Autowired
	public PlaceServiceImpl(PlaceMapper placeMapper) {
		this.placeMapper = placeMapper;
	}
	@Override
	public List<PlaceDto> placeList() throws SQLException {
		return placeMapper.placeList();
	}

}
