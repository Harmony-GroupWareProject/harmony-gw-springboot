package com.harmony.gw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmony.gw.dto.ApprovalDocResponseDTO;
import com.harmony.gw.dto.ApprovalDocSaveRequestDTO;
import com.harmony.gw.entity.ApprovalDoc;
import com.harmony.gw.entity.Approver;
import com.harmony.gw.entity.Employee;
import com.harmony.gw.entity.Referer;
import com.harmony.gw.repository.ApprovalDocRepository;
import com.harmony.gw.repository.ApproverRepository;
import com.harmony.gw.repository.EmployeeRepository;
import com.harmony.gw.repository.RefererRepository;

@Service
@Transactional
public class ApprovalServiceImpl {
	
	@Autowired
	private ApprovalDocRepository approvalDocRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RefererRepository refererRepository;
	
	@Autowired
	private ApproverRepository approverRepository;
	
	
	public void saveApprovalDoc(ApprovalDocSaveRequestDTO requestDTO) {
		Employee writer = employeeRepository.getById(requestDTO.getWriter());
		ApprovalDoc saveApproval = new ApprovalDoc();
		saveApproval.setDocType(requestDTO.getDocType());
		saveApproval.setEmployee(writer);
		saveApproval.setDocTitle(requestDTO.getDocTitle());
		saveApproval.setDocContent(requestDTO.getDocContent());
		
		saveApproval = approvalDocRepository.save(saveApproval);
		
		String[] referers = requestDTO.getReferences().split(",");
		for(String id : referers) {
			Referer referer = new Referer(saveApproval, id);
			refererRepository.save(referer);
		}
		
		String[] approvers = requestDTO.getApprovers().split(",");
		for(int i=0; i<approvers.length; i++) {
			Approver approver = null;
			if(i!=approvers.length-1) {
				approver = new Approver(saveApproval, approvers[i], i, "미결재", false);
			} else {
				approver = new Approver(saveApproval, approvers[i], i, "미결재", true);
			}
			approverRepository.save(approver);
		}
		
		
		
		
		
	}


	public ApprovalDocResponseDTO getApprovalDoc(String docIdx) {
		ApprovalDoc getApprovalDoc = approvalDocRepository.findByDocIdx(docIdx);
		ApprovalDocResponseDTO docResponseDTO = new ApprovalDocResponseDTO();
		docResponseDTO.setDocContent(getApprovalDoc.getDocContent());
		docResponseDTO.setDocTitle(getApprovalDoc.getDocTitle());
		docResponseDTO.setWriter(getApprovalDoc.getEmployee().getEmpName());
		
		return docResponseDTO;
	}
	

}
