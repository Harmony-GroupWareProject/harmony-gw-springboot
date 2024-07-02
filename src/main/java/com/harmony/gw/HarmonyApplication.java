package com.harmony.gw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harmony.gw.entity.Employee;
import com.harmony.gw.entity.Schedule;
import com.harmony.gw.repository.EmployeeRepository;
import com.harmony.gw.repository.ScheduleRepository;


@SpringBootApplication
public class HarmonyApplication implements CommandLineRunner {

	@Autowired
    private EmployeeRepository urepository;
	
	@Autowired
	private ScheduleRepository srepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HarmonyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 사용자 이름: user, 암호: user
		urepository.save(new Employee("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "이유림", "B", "010-6698-5279", "usejin0914@gmail.com", "매니저" ,"USER", LocalDate.of(2024,05,30)));
		urepository.save(new Employee("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW",  "황인환", "A", "010-0000-0000", "usejin00@0mail.com", "대표이사" ,"USER", LocalDate.of(2024,05,30)));
	
		 Schedule[] schedules = {
		            new Schedule(null, "Title 1", LocalDateTime.of(LocalDate.of(2023, 7, 1), LocalTime.of(10, 0)), LocalDateTime.of(LocalDate.of(2023, 7, 1), LocalTime.of(17, 0)), false),
		            new Schedule(null, "Title 2", LocalDateTime.of(LocalDate.of(2023, 7, 2), LocalTime.of(10, 0)), LocalDateTime.of(LocalDate.of(2023, 7, 2), LocalTime.of(18, 0)), true),
		            new Schedule(null, "Title 3", LocalDateTime.of(LocalDate.of(2023, 7, 3), LocalTime.of(8, 0)), LocalDateTime.of(LocalDate.of(2023, 7, 3), LocalTime.of(16, 0)), true),
		            new Schedule(null, "Title 4", LocalDateTime.of(LocalDate.of(2023, 7, 4), LocalTime.of(9, 30)), LocalDateTime.of(LocalDate.of(2023, 7, 4), LocalTime.of(17, 30)), true),
		            new Schedule(null, "Title 5", LocalDateTime.of(LocalDate.of(2023, 7, 5), LocalTime.of(9, 0)), LocalDateTime.of(LocalDate.of(2023, 7, 5), LocalTime.of(17, 0)), true),
		            new Schedule(null, "Title 6", LocalDateTime.of(LocalDate.of(2023, 7, 6), LocalTime.of(10, 10)), LocalDateTime.of(LocalDate.of(2023, 7, 6), LocalTime.of(18, 0)), false),
		            new Schedule(null, "Title 7", LocalDateTime.of(LocalDate.of(2023, 7, 7), LocalTime.of(8, 20)), LocalDateTime.of(LocalDate.of(2023, 7, 7), LocalTime.of(16, 0)), true),
		            new Schedule(null, "Title 8", LocalDateTime.of(LocalDate.of(2023, 7, 8), LocalTime.of(9, 30)), LocalDateTime.of(LocalDate.of(2023, 7, 8), LocalTime.of(17, 30)), false),
		            new Schedule(null, "Title 9", LocalDateTime.of(LocalDate.of(2023, 7, 9), LocalTime.of(9, 0)), LocalDateTime.of(LocalDate.of(2023, 7, 9), LocalTime.of(17, 0)), false),
		            new Schedule(null, "Title 10", LocalDateTime.of(LocalDate.of(2023, 7, 10), LocalTime.of(10, 25)), LocalDateTime.of(LocalDate.of(2023, 7, 10), LocalTime.of(18, 0)), true)
		        };

	        for (Schedule schedule : schedules) {
	            srepository.save(schedule);
	        }
	}
}
