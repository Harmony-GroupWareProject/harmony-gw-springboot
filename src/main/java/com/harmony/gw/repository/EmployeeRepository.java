package com.harmony.gw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.harmony.gw.entity.Employee;

@RepositoryRestResource(exported = false)
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	 @Query("SELECT e FROM Employee e WHERE e.empNo = :empNo AND e.delYN = 'N' AND e.hireDate <= CURRENT_DATE AND (e.outDate IS NULL OR e.outDate >= CURRENT_DATE)")
	    Optional<Employee> findByEmpNo(@Param("empNo") String empNo);
}
