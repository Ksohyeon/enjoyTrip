package com.ssafy.qna.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.qna.model.dto.QnaDto;
import com.ssafy.qna.model.dto.SearchCondition;

@Mapper
public interface QnaMapper {

	List<QnaDto> search(SearchCondition condition);

	int insert(QnaDto qna);

	QnaDto select(String qnano);

	int update(QnaDto qna);

	int delete(String qnano);

}
