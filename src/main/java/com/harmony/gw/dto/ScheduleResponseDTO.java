package com.harmony.gw.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ScheduleResponseDTO {
	// 일정 제목
	private String sTitle;
	
	// 시작날짜
	private LocalDate startDate;
	// 종료날짜
	private LocalDate endDate;
	// 시작시간
	private LocalTime startTime;
	// 종료시간
	private LocalTime endTime;
	
	// 하루종일 여부(true/false)
	private Boolean allDay;
}
