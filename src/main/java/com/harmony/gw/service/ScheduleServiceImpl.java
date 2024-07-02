package com.harmony.gw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmony.gw.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl {
	private final ScheduleRepository scheduleRepository;
	
	@Autowired
	public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	
}
