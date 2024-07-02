package com.harmony.gw;

import java.time.LocalDate;
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
	            new Schedule(50L, "Title 1", LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 2), LocalTime.of(9, 0), LocalTime.of(17, 0)),
	            new Schedule(51L, "Title 2", LocalDate.of(2023, 7, 2), LocalDate.of(2023, 7, 3), LocalTime.of(10, 0), LocalTime.of(18, 0)),
	            new Schedule(52L, "Title 3", LocalDate.of(2023, 7, 3), LocalDate.of(2023, 7, 4), LocalTime.of(8, 0), LocalTime.of(16, 0)),
	            new Schedule(53L, "Title 4", LocalDate.of(2023, 7, 4), LocalDate.of(2023, 7, 5), LocalTime.of(9, 30), LocalTime.of(17, 30)),
	            new Schedule(54L, "Title 5", LocalDate.of(2023, 7, 5), LocalDate.of(2023, 7, 6), LocalTime.of(9, 0), LocalTime.of(17, 0)),
	            new Schedule(55L, "Title 6", LocalDate.of(2023, 7, 6), LocalDate.of(2023, 7, 7), LocalTime.of(10, 0), LocalTime.of(18, 0)),
	            new Schedule(56L, "Title 7", LocalDate.of(2023, 7, 7), LocalDate.of(2023, 7, 8), LocalTime.of(8, 0), LocalTime.of(16, 0)),
	            new Schedule(57L, "Title 8", LocalDate.of(2023, 7, 8), LocalDate.of(2023, 7, 9), LocalTime.of(9, 30), LocalTime.of(17, 30)),
	            new Schedule(58L, "Title 9", LocalDate.of(2023, 7, 9), LocalDate.of(2023, 7, 10), LocalTime.of(9, 0), LocalTime.of(17, 0)),
	            new Schedule(59L, "Title 10", LocalDate.of(2023, 7, 10), LocalDate.of(2023, 7, 11), LocalTime.of(10, 0), LocalTime.of(18, 0)),
	        };

	        for (Schedule schedule : schedules) {
	            srepository.save(schedule);
	        }
	}
}
