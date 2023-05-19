package com.ssafy.plan.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService{
	@Autowired
	private PlanMapper planMapper;
	
	
	public PlanServiceImpl(PlanMapper planMapper) {
		this.planMapper = planMapper;
	}

	@Override
	public int createPlan(PlanDto planDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PlanDto> listPlan() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanDto getPlan(String planNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePlan(PlanDto planDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePlan(String planNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
