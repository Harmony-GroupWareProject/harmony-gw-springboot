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

@Table(name = "organization")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @Column(nullable = false, unique = true)
    private String orgCd;

    @Column(nullable = false)
    private String orgName;

    private String upperOrgCd;
    
    @CreationTimestamp
    private LocalDate createDate;
    
    @UpdateTimestamp
    private LocalDateTime updateDate;

	public Organization(String orgCd, String orgName, String upperOrgCd) {
		this.orgCd = orgCd;
		this.orgName = orgName;
		this.upperOrgCd = upperOrgCd;
	}
    
    
}
