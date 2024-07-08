package com.harmony.gw.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.harmony.gw.dto.UserRegisterDTO;
import com.harmony.gw.entity.Employee;
import com.harmony.gw.repository.EmployeeRepository;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private EmployeeRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Employee saveUser(UserRegisterDTO user) {
    	Employee saveUser = new Employee(user.getEmpNo(),
    			passwordEncoder.encode(user.getPassword()),
    			user.getEmpName(),
    			user.getOrgCd(),
    			user.getPhoneNum(),
    			user.getEmail(),
    			user.getPosition(),
    			user.getRole(),
    			user.getHireDate());
    	System.out.println(saveUser.getPassword());
        return userRepository.save(saveUser);
    }
	
	public Optional<Employee> findByEmpNo(String userId) {
		return userRepository.findByEmpNo(userId);
	}
	
	public boolean existsByEmpNo(String empNo) {
		return userRepository.existsByEmpNo(empNo);
	}

}
