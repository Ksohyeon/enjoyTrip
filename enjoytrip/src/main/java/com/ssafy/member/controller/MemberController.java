package com.ssafy.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController
//@Controller
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

//	@GetMapping("/join")
//	public String join() {
//		return "user/join";
//	}
	
	//로그인 유무
	@GetMapping("/islogin")
	@ResponseBody
	public ResponseEntity<?> islogin(HttpSession session) throws Exception{
		MemberDto dto = (MemberDto) session.getAttribute("userinfo");
		if (dto != null) return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
		else {
			dto = new MemberDto();
			return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{userid}")
	@ResponseBody
	public String idCheck(@PathVariable("userid") String userId) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = memberService.idCheck(userId);
		return cnt + "";
	}
	
	@PostMapping("/join")
	public String join(@RequestBody MemberDto memberDto) {
		logger.debug("memberDto info : {}", memberDto);
		try {
			System.out.println(memberDto);
			memberService.joinMember(memberDto);
			return "redirect:/";
		} catch (Exception e) {
			return "error/error";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody MemberDto loginmember
			, Model model, HttpSession session, HttpServletResponse response) {
		String userId = loginmember.getUserId();
		String userPwd = loginmember.getUserPwd();
		logger.debug("userid : {}, userpwd : {}", userId, userPwd);
		System.out.println("userid : "+userId+ " userpwd : "+userPwd);
		try {
			MemberDto memberDto = memberService.loginMember(userId, userPwd);
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
				return "redirect:/";
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
				return "user/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list() {
		return "redirect:/list.html";
	}
}
