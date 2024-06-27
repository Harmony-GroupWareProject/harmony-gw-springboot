package com.harmony.gw.dto;

import java.util.List;

import com.harmony.gw.entity.Employee;
import com.harmony.gw.entity.Organization;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrgEmpResponseDTO {

	List<Organization> orgList;
	
	List<Employee> empList;
}
