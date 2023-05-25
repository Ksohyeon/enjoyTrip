package com.ssafy.plan.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.LikeDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.service.PlanService;
import com.ssafy.qna.controller.QnaController;

@RestController
@RequestMapping("/plan")
@CrossOrigin("*")
public class PlanController {
	private final Logger logger = LoggerFactory.getLogger(QnaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private PlanService planService;

	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}
	
	@GetMapping("/myplan/{userId}")
	public ResponseEntity<?> listMyPlan(@PathVariable("userId") String userId) throws Exception{
		List<PlanDto> list = planService.listMyPlan(userId);
		System.out.println(list.size());
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PlanDto>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@GetMapping
	public ResponseEntity<?> listPlan() throws Exception {
		List<PlanDto> list = planService.listPlan();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PlanDto>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<?> getPlan(@PathVariable("no") String no) throws Exception{
		PlanDto planDto = planService.getPlan(no);
		if (planDto != null) {
			return new ResponseEntity<PlanDto>(planDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@PostMapping
	public ResponseEntity<String> writePlan(@RequestBody Map<String, Object> map) throws Exception{
		PlanDto planDto = new PlanDto((String) map.get("title"),(String)  map.get("content"), (String) map.get("startDate"),(String)  map.get("endDate"), (String) map.get("theme"), new MemberDto((String) map.get("userId")));
		System.out.println(planDto);
		List<String> places = (List<String>) map.get("places");
		System.out.println(places);
		if (planService.createPlan(planDto, places) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{no}")
	public ResponseEntity<?> updatePlan(@PathVariable("no") String no,@RequestBody Map<String, Object> map) throws Exception{
		PlanDto planDto = new PlanDto((String) map.get("title"),(String)  map.get("content"), (String) map.get("startDate"),(String)  map.get("endDate"), (String) map.get("theme"), new MemberDto((String) map.get("userId")));
		planDto.setNo(no);
		System.out.println(planDto);
		List<String> places = (List<String>) map.get("places");
		System.out.println(places);
		if (planService.updatePlan(planDto, places) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{no}")
	public ResponseEntity<String> deletePlan(@PathVariable("no") String no) throws Exception{
		if (planService.deletePlan(no) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	@PostMapping("/{no}/like/{user_id}")
	public ResponseEntity<String> likePlan(@PathVariable("no") String no, @PathVariable("user_id") String userId) throws Exception{
		if (planService.likePlan(no, userId) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{no}/like/{user_id}")
	public ResponseEntity<String> unlikePlan(@PathVariable("no") String no, @PathVariable("user_id") String userId) throws Exception{
		if (planService.unLikePlan(no, userId) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
