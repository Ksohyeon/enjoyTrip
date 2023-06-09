package com.ssafy.place.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.place.model.dto.PlaceDto;
import com.ssafy.place.model.mapper.PlaceMapper;

@Service
public class PlaceServiceImpl implements PlaceService {

	private PlaceMapper placeMapper;

	@Autowired
	public PlaceServiceImpl(PlaceMapper placeMapper) {
		this.placeMapper = placeMapper;
	}

	@Override
	public List<PlaceDto> placeList() throws SQLException {
		return placeMapper.placeList();
	}

	@Override
	public PlaceDto getPlace(String no) throws SQLException {
		PlaceDto placeDto = placeMapper.getPlace(no);
		placeDto.setLikeUsers(placeMapper.listLikeUsers(no));
		System.out.println(placeDto);
		return placeDto;
	}

	@Override
	public int createPlace(PlaceDto placeDto) {
		return placeMapper.createPlace(placeDto);
	}

	@Override
	public int updatePlace(PlaceDto placeDto) {
		return placeMapper.updatePlace(placeDto);
	}

	@Override
	public int deletePlace(String no) {
		return placeMapper.deletePlace(no);
	}

	@Override
	public int updateHit(String no) {
        return placeMapper.updateHit(no);
	}

	@Override
	public String getImage(String no) {
		return placeMapper.getImage(no);
	}

	@Override
	public int likePlan(String no, String userId) {
		return placeMapper.likePlan(no, userId);
	}

	@Override
	public int unLikePlan(String no, String userId) {
		return placeMapper.unLikePlan(no,  userId);
	}

}
