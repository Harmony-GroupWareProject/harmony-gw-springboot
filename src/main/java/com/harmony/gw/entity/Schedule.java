package com.harmony.gw.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "schedule")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "schedule_seq", sequenceName = "schedule_seq", allocationSize = 1)
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
    private Long scheduleIdx;
	// = autoincrement
	
	@Column(nullable = false)
    private String title;
    
    @Column(nullable = false, name="`start`")
	private LocalDateTime start;
	
    @Column(nullable = false, name="`end`")
	private LocalDateTime end;
    
    @Column(nullable = false)
    private Boolean allDay;
    
//  @Column(nullable = false)
//  private int scheduleType; //1: 회사일정 2: 개인일정 
    
//  @Column(nullable = false)
//  private String createEmpNo;
    
    
	
	
	
}
