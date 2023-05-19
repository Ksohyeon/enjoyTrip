package com.ssafy.place.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.place.model.dto.PlaceDto;

public interface PlaceService {
	public List<PlaceDto> placeList() throws SQLException;

}
