package com.harmony.gw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmony.gw.entity.Schedule;
import com.harmony.gw.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl {
	private final ScheduleRepository scheduleRepository;
	
	@Autowired
	public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	public List<Schedule> getScheduleList(){
		List<Schedule> schduleList = scheduleRepository.findAll();
		
		return schduleList;
	}
	
//	public List<Schedule> createScheduleList(){
//		
//	}
	
	
}
