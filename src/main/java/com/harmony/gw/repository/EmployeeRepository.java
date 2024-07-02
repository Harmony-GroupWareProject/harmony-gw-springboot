package com.harmony.gw.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.harmony.gw.entity.Employee;

@RepositoryRestResource(exported = false)
public interface EmployeeRepository extends CrudRepository<Employee, String> {

	Optional<Employee> findByEmpNo(String empNo);
}
