package com.harmony.gw.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ScheduleRequestDTO {
	
	// 일정 제목
	private String sTitle;
	// 날짜(시작/종료)
	private LocalDateTime sStartDate;
	private LocalDateTime sEndDate;
	// 하루종일 여부(true/false)
	private Boolean allDay;

	
	
}
