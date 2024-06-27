package com.harmony.gw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.dto.OrgEmpResponseDTO;
import com.harmony.gw.entity.Employee;
import com.harmony.gw.entity.Organization;
import com.harmony.gw.service.OrgEmpServiceImpl;


@RestController
public class OrgEmpController {

	@Autowired
	OrgEmpServiceImpl orgEmpService;
	
	@GetMapping("/orgEmpList")
	public OrgEmpResponseDTO getOrgEmpList() {
		OrgEmpResponseDTO response = new OrgEmpResponseDTO(orgEmpService.getOrgList(), orgEmpService.getEmpList());
		for (Organization org : orgEmpService.getOrgList()) {
			System.out.println(org);
		}
		for (Employee emp : orgEmpService.getEmpList()) {
			System.out.println(emp);
		}
		return response;
	}
	
}
