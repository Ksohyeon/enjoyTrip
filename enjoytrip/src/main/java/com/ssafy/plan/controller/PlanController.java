package com.ssafy.plan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
