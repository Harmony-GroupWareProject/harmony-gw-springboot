package com.harmony.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.dto.ApprovalDocResponseDTO;
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
	
	@GetMapping("/getDocContent")
	public ApprovalDocResponseDTO getApprovalDocContent(@RequestParam String docIdx) {
		ApprovalDocResponseDTO approvalDocContent = new ApprovalDocResponseDTO();
		approvalDocContent = approvalServiceImpl.getApprovalDoc(docIdx);
		return approvalDocContent; 
	}
}
