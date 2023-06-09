package com.ssafy.place.model.mapper;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.place.model.dto.PlaceDto;

@Mapper
public interface PlaceMapper {
	List<PlaceDto> placeList() throws SQLException;
	PlaceDto getPlace(String no) throws SQLException;
	int createPlace(PlaceDto placeDto);
	int deletePlace(String no);
	int updatePlace(PlaceDto placeDto);
	int updateHit(String no);
	String getImage(String no);
	List<MemberDto> listLikeUsers(String no);
	int unLikePlan(String no, String userId);
	int likePlan(String no, String userId);
}
