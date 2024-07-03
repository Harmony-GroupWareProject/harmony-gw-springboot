package com.harmony.gw.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmony.gw.dto.ScheduleRequestDTO;
import com.harmony.gw.entity.Schedule;
import com.harmony.gw.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl {
	private final ScheduleRepository scheduleRepository;
	
	@Autowired
	public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	// 일정 저장하기(1개)
	public void saveSchedule(ScheduleRequestDTO scheduleRequestDTO){
	        Schedule schedule = new Schedule();
	        
	        schedule.setTitle(scheduleRequestDTO.getTitle());
	        schedule.setStart(scheduleRequestDTO.getStart());
	        schedule.setEnd(scheduleRequestDTO.getEnd());
	        schedule.setAllDay(scheduleRequestDTO.getAllDay());
	        
	        Schedule savedSchedule = scheduleRepository.save(schedule);
	    
	        System.out.println("=== Service :: saveSchedule : " + savedSchedule);
	}
	
	// 모든 리스트 받아오기
	public List<Schedule> getScheduleList(){
		List<Schedule> schduleList = scheduleRepository.findAll();
		
		return schduleList;
	}
	
	// 일정 업데이트하기(1개)
	public void updateSchedule(ScheduleRequestDTO scheduleRequestDTO) {
		Schedule schedule = scheduleRepository.findByScheduleIdx(scheduleRequestDTO.getScheduleIdx());
		
		schedule.setTitle(scheduleRequestDTO.getTitle());
		schedule.setStart(scheduleRequestDTO.getStart());
		schedule.setEnd(scheduleRequestDTO.getEnd());
		schedule.setAllDay(scheduleRequestDTO.getAllDay());
		
		Schedule updatedSchedule = scheduleRepository.save(schedule);
		
		System.out.println("=== Service :: updateSchedule : ====" + updatedSchedule);
	}
	
	// 일정 삭제하기(1개)
	public void deleteSchedule(Long scheduleIdx) {
		Schedule schedule = scheduleRepository.findByScheduleIdx(scheduleIdx);
		
		scheduleRepository.delete(schedule);
		
		System.out.println("=====delete 성공!!!!========");
	}
	
	
	
}
