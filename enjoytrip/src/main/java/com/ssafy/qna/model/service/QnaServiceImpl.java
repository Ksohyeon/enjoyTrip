package com.ssafy.qna.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.qna.model.dto.QnaDto;
import com.ssafy.qna.model.dto.SearchCondition;
import com.ssafy.qna.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService{
	
	private QnaMapper qnaMapper;

	public QnaServiceImpl(QnaMapper qnaMapper) {
		super();
		this.qnaMapper = qnaMapper;
	}

	@Override
	public List<QnaDto> search(SearchCondition condition) throws Exception {
		return qnaMapper.search(condition);
	}

	@Override
	public int insert(QnaDto qna) throws Exception {
		return qnaMapper.insert(qna);
	}

	@Override
	public QnaDto select(String qnano) throws Exception {
		return qnaMapper.select(qnano);
	}

	@Override
	public int update(QnaDto qna) throws Exception {
		return qnaMapper.update(qna);
	}

	@Override
	public int delete(String qnano) throws Exception {		
		return qnaMapper.delete(qnano);
	}

}
