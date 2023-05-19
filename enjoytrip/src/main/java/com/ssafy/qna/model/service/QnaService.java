package com.ssafy.qna.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.qna.model.dto.QnaDto;

public interface QnaService {

	int createQna(QnaDto qnaDto) throws SQLException;
	List<QnaDto> listQna() throws SQLException;
	QnaDto getQna(String no) throws SQLException;
	int updateQna(QnaDto qnaDto) throws SQLException;
	int deleteQna(String no) throws SQLException;

}
