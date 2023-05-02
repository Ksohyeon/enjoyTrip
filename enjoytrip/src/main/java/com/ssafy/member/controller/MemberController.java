package com.ssafy.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.SearchResponseDto;
import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
//	//로그인 유무
//	@GetMapping("/islogin")
//	public ResponseEntity<?> islogin(HttpSession session) throws Exception{
//		MemberDto dto = (MemberDto) session.getAttribute("userinfo");
//		if (dto != null) return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
//		else {
//			dto = new MemberDto();
//			return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
//		}
//	}
	
//	@GetMapping("/{userid}")
//	@ResponseBody
//	public String idCheck(@PathVariable("userid") String userId) throws Exception {
//		logger.debug("idCheck userid : {}", userId);
//		int cnt = memberService.idCheck(userId);
//		return cnt + "";
//	}
	
	@PostMapping("/join")
	public void join(@RequestBody MemberDto memberDto) {
		logger.debug("memberDto info : {}", memberDto);
		try {
			System.out.println(memberDto);
			memberService.joinMember(memberDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberDto loginmember
			,HttpSession session) {
		String userId = loginmember.getUserId();
		String userPwd = loginmember.getUserPwd();
		System.out.println("userid : "+userId+ " userpwd : "+userPwd);
		MemberDto memberDto = null;
		try {
			memberDto = memberService.loginMember(userId, userPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(memberDto != null) {
			session.setAttribute("userinfo", memberDto);
			/*
			Cookie cookie = new Cookie("ssafy_id", userId);
			cookie.setPath("/board");
			if("ok".equals(saveid)) {
				cookie.setMaxAge(60*60*24*365*40);
			} else {
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie); */
			System.out.println("return dto: "+memberDto);
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<MemberDto>(new MemberDto(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> select(@PathVariable("userid") String userid) {
		MemberDto loginUser = null;
		try {
			loginUser = memberService.getMember(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<MemberDto>(loginUser, HttpStatus.OK);
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody MemberDto memberDto) {
		System.out.println("update: "+ memberDto.toString());
		MemberDto dto = null;
		try {
			memberService.updateMember(memberDto);
			dto = memberService.getMember(memberDto.getUserId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
		
	}
	
	@GetMapping("/admin/user")
	public ResponseEntity<?> userList() throws Exception {
		List<MemberDto> userList = memberService.listMember();
		if (userList != null && !userList.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(userList, HttpStatus.OK); // 200
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
}
