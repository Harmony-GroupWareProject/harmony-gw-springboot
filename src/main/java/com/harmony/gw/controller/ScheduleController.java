package com.harmony.gw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.dto.ScheduleRequestDTO;
import com.harmony.gw.dto.ScheduleResponseDTO;
import com.harmony.gw.entity.Schedule;
import com.harmony.gw.service.ScheduleServiceImpl;

@RestController
public class ScheduleController {
	private ScheduleServiceImpl scheduleServiceImpl;
	
	@Autowired
	public ScheduleController(ScheduleServiceImpl scheduleServiceImpl) {
		this.scheduleServiceImpl = scheduleServiceImpl;
	}
	
	// create
	@PostMapping(value="/scheduleSave")
	public ResponseEntity<Boolean> createSchedule(
			ScheduleRequestDTO scheduleRequestDTO){
		
//		Boolean response = 
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
				
	}
	
	// read
	@GetMapping(value="/scheduleList")
	public ResponseEntity<List<Schedule>> selectScheduleInfo(){
		List<Schedule> scheduleList = scheduleServiceImpl.getScheduleList();
		
		return ResponseEntity.status(HttpStatus.OK).body(scheduleList);
	}
	
	
}
