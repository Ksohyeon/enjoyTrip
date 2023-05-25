package com.ssafy.plan.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ssafy.plan.model.dto.LikeDto;
import com.ssafy.plan.model.dto.PlanDto;

public interface PlanService {
	int createPlan(PlanDto planDto, List<String> places) throws SQLException;
	List<PlanDto> listPlan() throws SQLException;
	PlanDto getPlan(String planNo) throws SQLException;
	int updatePlan(PlanDto planDto, List<String> places) throws SQLException;
	int deletePlan(String planNo) throws SQLException;
	
	int likePlan(String planNo, String userId) throws SQLException;
	int unLikePlan(String planNo, String userId) throws SQLException;
	List<PlanDto> listMyPlan(String userId) throws SQLException;
}
