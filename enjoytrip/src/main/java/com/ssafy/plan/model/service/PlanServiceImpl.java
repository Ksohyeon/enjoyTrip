package com.ssafy.plan.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.plan.model.dto.AttrDto;
import com.ssafy.plan.model.dto.LikeDto;
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
	@Transactional
	public int createPlan(PlanDto planDto, List<String> places) throws SQLException {
		planMapper.createPlan(planDto);
		for (int i=0; i<places.size(); i++) {
			planMapper.createAttr(places.get(i), planDto.getNo(), i+1);
		}
		return 1;
	}

	@Override
	public List<PlanDto> listPlan() throws SQLException {
		
		return planMapper.listPlan();
	}

	@Override
	public PlanDto getPlan(String planNo) throws SQLException {
		PlanDto planDto = planMapper.getPlan(planNo);
		planDto.setPlaces(planMapper.listAttr(planNo));
		planDto.setLikeUsers(planMapper.listLikeUsers(planNo));
		planMapper.updateHit(planNo);
		return planDto;
	}

	@Override
	@Transactional
	public int updatePlan(PlanDto planDto, List<String> places) throws SQLException {
		planMapper.updatePlan(planDto);
		String planNo = planDto.getNo();
		planMapper.deleteAttr(planNo);
		for (int i=0; i<places.size(); i++) {
			planMapper.createAttr(places.get(i), planNo, i+1);
		}
		return 1;
	}

	@Override
	public int deletePlan(String planNo) throws SQLException {
		return planMapper.deletePlan(planNo);
	}

	@Override
	public int likePlan(String planNo, String userId) throws SQLException {
		return planMapper.likePlan(planNo, userId);
	}

	@Override
	public int unLikePlan(String planNo, String userId) throws SQLException {
		return planMapper.unLikePlan(planNo, userId);
	}

	@Override
	public List<PlanDto> listMyPlan(String userId) throws SQLException {
		return planMapper.listMyPlan(userId);
	}


}
