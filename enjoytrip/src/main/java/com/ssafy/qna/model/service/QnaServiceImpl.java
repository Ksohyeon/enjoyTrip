package com.ssafy.qna.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.qna.model.dto.QnaDto;
import org.springframework.stereotype.Service;
import com.ssafy.qna.model.dto.QnaDto;
import com.ssafy.qna.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService{

	@Autowired
	private QnaMapper qnaMapper;

	public QnaServiceImpl(QnaMapper qnaMapper) {
		super();
		this.qnaMapper = qnaMapper;
	}

	@Override
	public int createQna(QnaDto qnaDto) throws SQLException {
		return qnaMapper.createQna(qnaDto);
	}

	@Override
	public List<QnaDto> listQna() throws SQLException {
		return qnaMapper.listQna();
	}

	@Override
	public QnaDto getQna(String no) throws SQLException {
		return qnaMapper.getQna(no);
	}

	@Override
	public int updateQna(QnaDto qnaDto) throws SQLException {
		return qnaMapper.updateQna(qnaDto);
		
	}

	@Override
	public int deleteQna(String no) throws SQLException {
		return qnaMapper.deleteQna(no);
		
	}
	
}
