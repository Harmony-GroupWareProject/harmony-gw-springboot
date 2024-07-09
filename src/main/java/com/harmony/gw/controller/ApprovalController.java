package com.harmony.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.dto.ApprovalDocSaveRequestDTO;
import com.harmony.gw.service.ApprovalServiceImpl;

@RestController
public class ApprovalController {
	
	@Autowired
	private ApprovalServiceImpl approvalServiceImpl;
	
	@PostMapping("/saveApprovalDoc")
	public void saveApprovalDoc(@RequestBody ApprovalDocSaveRequestDTO requestDTO) {
		approvalServiceImpl.saveApprovalDoc(requestDTO);
	}
}
