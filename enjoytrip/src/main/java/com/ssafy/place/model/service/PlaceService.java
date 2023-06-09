package com.ssafy.place.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.place.model.dto.PlaceDto;

public interface PlaceService {
	List<PlaceDto> placeList() throws SQLException;
	PlaceDto getPlace(String no) throws SQLException;
	int createPlace(PlaceDto placeDto);
	int deletePlace(String no);
	int updatePlace(PlaceDto placeDto);
	int updateHit(String no);
	String getImage(String no);
	int likePlan(String no, String userId);
	int unLikePlan(String no, String userId);

}
