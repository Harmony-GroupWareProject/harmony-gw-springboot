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
	
	public void saveScheduleList(ScheduleRequestDTO scheduleRequestDTO){
		Schedule schedule = new Schedule();
		schedule.setSTitle(scheduleRequestDTO.getSTitle());
		System.out.println();
		schedule.setStart(null);
		schedule.setEnd(null);
		schedule.setAllDay(scheduleRequestDTO.getAllDay());
		Schedule savedSchedule = scheduleRepository.save(schedule);
		System.out.println("=== Service :: saveSchedule : " + savedSchedule  );
		
	}
	
	public List<Schedule> getScheduleList(){
		List<Schedule> schduleList = scheduleRepository.findAll();
		
		return schduleList;
	}
	
	public List<Schedule> getScheduleReactList(){
		List<Schedule> scheduleList = scheduleRepository.findAll();
		
		
		return scheduleList;
	}
	
	
	
	
}
