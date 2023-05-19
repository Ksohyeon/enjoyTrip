package com.ssafy.plan.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.plan.model.dto.PlanDto;

public interface PlanService {
	int createPlan(PlanDto planDto) throws SQLException;
	List<PlanDto> listPlan() throws SQLException;
	PlanDto getPlan(String planNo) throws SQLException;
	int updatePlan(PlanDto planDto) throws SQLException;
	int deletePlan(String planNo) throws SQLException;
}
