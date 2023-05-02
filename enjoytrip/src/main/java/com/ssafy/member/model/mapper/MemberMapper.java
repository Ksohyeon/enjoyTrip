package com.ssafy.member.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.dto.MemberDto;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws SQLException;
	int joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(Map<String, String> map) throws SQLException;
	List<MemberDto> listMember() throws SQLException;
	MemberDto getMember(String userId) throws SQLException;
	void updateMember(MemberDto memberDto) throws SQLException;
	void deleteMember(String userId) throws SQLException;
	
}
