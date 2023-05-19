package com.ssafy.place.model.mapper;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ssafy.place.model.dto.PlaceDto;

@Mapper
public interface PlaceMapper {
	List<PlaceDto> placeList() throws SQLException;
}
