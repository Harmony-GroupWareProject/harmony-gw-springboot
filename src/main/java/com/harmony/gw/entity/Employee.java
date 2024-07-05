package com.harmony.gw.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @Column(nullable = false, unique = true)
    private String empNo;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String empName;

    private String orgCd;

    @Column(nullable = false)
    private String phoneNum;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String position;
    
    @Column(nullable = false)
    private String role;
    
    private LocalDate hireDate;
    
    private LocalDate outDate;

    @Column(length = 1)
    private String delYN;
    
    @CreationTimestamp
    private LocalDate createDate;
    
    @UpdateTimestamp
    private LocalDateTime updateDate;

	public Employee(String empNo, String password, String empName, String orgCd, String phoneNum, String email,
			String position, String role, LocalDate hireDate) {
		this.empNo = empNo;
		this.password = password;
		this.empName = empName;
		this.orgCd = orgCd;
		this.phoneNum = phoneNum;
		this.email = email;
		this.position = position;
		this.role = role;
		this.hireDate = hireDate;
		this.delYN = "N";
	}
    
    
}
