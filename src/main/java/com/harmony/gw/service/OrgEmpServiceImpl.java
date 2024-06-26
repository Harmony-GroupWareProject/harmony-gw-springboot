package com.harmony.gw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harmony.gw.entity.Employee;
import com.harmony.gw.entity.EmployeeRepository;
import com.harmony.gw.entity.Organization;
import com.harmony.gw.entity.OrganizationRepository;

@Service
@Transactional
public class OrgEmpServiceImpl {

	@Autowired
	OrganizationRepository orgRepository;
	
	@Autowired
	EmployeeRepository empRepository;
	
	public List<Organization> getOrgList() {
		List<Organization> orgList = (List<Organization>)orgRepository.findAll(); 
		
		return orgList;
	}
	
	public List<Employee> getEmpList() {
		List<Employee> empList = (List<Employee>)empRepository.findAll(); 
		
		return empList;
	}
	
	
	
	
}

