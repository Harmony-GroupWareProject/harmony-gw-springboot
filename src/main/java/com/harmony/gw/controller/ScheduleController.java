package com.harmony.gw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.dto.ScheduleRequestDTO;
import com.harmony.gw.entity.Schedule;
import com.harmony.gw.service.ScheduleServiceImpl;

@RestController
public class ScheduleController {
	
	@Autowired
	ScheduleServiceImpl scheduleServiceImpl;
	
	// create(save)
	@PostMapping(value = "/scheduleSave")
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        	Schedule saveSchedule = scheduleServiceImpl.saveSchedule(scheduleRequestDTO); 
            return ResponseEntity.status(HttpStatus.OK).body(saveSchedule);
        
    }
	
	// read
	@GetMapping(value="/scheduleList")
	public ResponseEntity<List<Schedule>> selectScheduleInfo(){
		List<Schedule> scheduleList = scheduleServiceImpl.getScheduleList();
//		System.out.println("get 스케쥴 리스트!!------------------" + scheduleList);
		return ResponseEntity.status(HttpStatus.OK).body(scheduleList);
	}
	
	// update
	@PutMapping(value="/scheduleUpdate")
	public ResponseEntity<Schedule> updateScheduleInfo(@RequestBody ScheduleRequestDTO scheduleRequestDTO){
		System.out.println(scheduleRequestDTO.getScheduleIdx());
		System.out.println("=============== scheduleRequestDTO ============ : " + scheduleRequestDTO);
		
		Schedule updateSchedule = scheduleServiceImpl.updateSchedule(scheduleRequestDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateSchedule);
	}
	
	// delete 
	@DeleteMapping(value="/scheduleDelete")
	public ResponseEntity<Boolean> deleteScheduleInfo(@RequestBody Long scheduleIdx){
		System.out.println(scheduleIdx);
		System.out.println("=============== delete ============ : " + scheduleIdx);
		
		scheduleServiceImpl.deleteSchedule(scheduleIdx);
		
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
	
	
}
