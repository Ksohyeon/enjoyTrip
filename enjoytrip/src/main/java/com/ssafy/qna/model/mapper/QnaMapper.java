package com.ssafy.qna.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.qna.model.dto.QnaCommentDto;
import com.ssafy.qna.model.dto.QnaDto;
@Mapper
public interface QnaMapper {
	int createQna(QnaDto qnaDto) throws SQLException;
	List<QnaDto> listQna() throws SQLException;
	QnaDto getQna(String no) throws SQLException;
	int updateQna(QnaDto qnaDto) throws SQLException;
	int deleteQna(String no) throws SQLException;
	
	int createQnaComment(QnaCommentDto qnaCommentDto) throws SQLException;
	List<QnaCommentDto> listQnaComment(String qnaNo) throws SQLException;
	int updateQnaComment(QnaCommentDto qnaCommentDto) throws SQLException;
	int deleteQnaComment(String commentNo) throws SQLException;
}
