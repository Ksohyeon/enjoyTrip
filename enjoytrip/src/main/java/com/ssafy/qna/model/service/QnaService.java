package com.ssafy.qna.model.service;

import java.util.List;

import com.ssafy.qna.model.dto.QnaDto;
import com.ssafy.qna.model.dto.SearchCondition;

public interface QnaService {

	List<QnaDto> search(SearchCondition condition) throws Exception;

	int insert(QnaDto qna) throws Exception;

	QnaDto select(String qnano) throws Exception;

	int update(QnaDto qna) throws Exception;

	int delete(String qnano)throws Exception;

}
