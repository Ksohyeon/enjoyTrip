package com.ssafy.plan.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.AttrDto;
import com.ssafy.plan.model.dto.PlanDto;
@Mapper
public interface PlanMapper {
	int createPlan(PlanDto planDto) throws SQLException;
	List<PlanDto> listPlan() throws SQLException;
	PlanDto getPlan(String planNo) throws SQLException;
	int updatePlan(PlanDto planDto) throws SQLException;
	int deletePlan(String planNo) throws SQLException;
	void updateHit(String planNo) throws SQLException;
	
	//장소 관련
	int createAttr(String attrNo, String planNo, int order) throws SQLException;
	List<AttrDto> listAttr(String planNo) throws SQLException;
	int deleteAttr(String planNo) throws SQLException;
	//좋아요 관련
	List<MemberDto> listLikeUsers(String planNo) throws SQLException;
	int likePlan(String planNo, String userId) throws SQLException;
	int unLikePlan(String planNo, String userId) throws SQLException;
}
