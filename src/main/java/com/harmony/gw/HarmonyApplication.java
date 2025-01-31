package com.harmony.gw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harmony.gw.entity.DocumentTemplate;
import com.harmony.gw.entity.Employee;
import com.harmony.gw.entity.Organization;
import com.harmony.gw.entity.Schedule;
import com.harmony.gw.repository.DocumentTemplateRepository;
import com.harmony.gw.repository.EmployeeRepository;
import com.harmony.gw.repository.NoticeRepository;
import com.harmony.gw.repository.OrganizationRepository;
import com.harmony.gw.repository.ScheduleRepository;
import com.harmony.gw.util.MethodUtil;

@SpringBootApplication
public class HarmonyApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository urepository;

	@Autowired
	private ScheduleRepository srepository;

	@Autowired
	private OrganizationRepository orepository;
	
	@Autowired
	private DocumentTemplateRepository drepository;
	public static void main(String[] args) {
		SpringApplication.run(HarmonyApplication.class, args);
	}
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public void run(String... args) throws Exception {

		// 사용자 이름: user, 암호: user
		urepository.save(new Employee("1001", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "이유림",
				"B", "010-6698-5279", "usejin0914@gmail.com", "매니저", "USER", LocalDate.of(2024, 05, 30)));
		urepository.save(new Employee("1002", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "황인환",
				"A", "010-0000-0000", "usejin00@0mail.com", "대표이사", "ADMIN", LocalDate.of(2024, 05, 30)));

		Schedule[] schedules = {
	            new Schedule(1l, "Title 1", LocalDateTime.of(LocalDate.of(2024, 7, 1), LocalTime.of(10, 0)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 1), LocalTime.of(17, 0)), false, 2, "user"),
	            new Schedule(2l, "Title 2", LocalDateTime.of(LocalDate.of(2024, 7, 2), LocalTime.of(10, 0)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 2), LocalTime.of(18, 0)), true, 1, "user"),
	            new Schedule(3l, "Title 3", LocalDateTime.of(LocalDate.of(2024, 7, 3), LocalTime.of(8, 0)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 3), LocalTime.of(16, 0)), true, 1, "user"),
	            new Schedule(4l, "Title 4", LocalDateTime.of(LocalDate.of(2024, 7, 4), LocalTime.of(9, 30)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 4), LocalTime.of(17, 30)), true, 2, "user"),
	            new Schedule(5l, "Title 5", LocalDateTime.of(LocalDate.of(2024, 7, 5), LocalTime.of(9, 0)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 10), LocalTime.of(17, 0)), true, 1, "user"),
	            new Schedule(6l, "Title 6", LocalDateTime.of(LocalDate.of(2024, 7, 6), LocalTime.of(10, 10)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 6), LocalTime.of(18, 0)), false, 1, "user"),
	            new Schedule(7l, "Title 7", LocalDateTime.of(LocalDate.of(2024, 7, 7), LocalTime.of(8, 20)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 7), LocalTime.of(16, 0)), true, 2, "user"),
	            new Schedule(8l, "Title 8", LocalDateTime.of(LocalDate.of(2024, 7, 8), LocalTime.of(9, 30)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 8), LocalTime.of(17, 30)), false, 1, "user"),
	            new Schedule(9l, "Title 9", LocalDateTime.of(LocalDate.of(2024, 7, 9), LocalTime.of(9, 0)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 9), LocalTime.of(17, 0)), false, 1, "user"),
	            new Schedule(10l, "Title 10", LocalDateTime.of(LocalDate.of(2024, 7, 10), LocalTime.of(10, 25)),
	                  LocalDateTime.of(LocalDate.of(2024, 7, 10), LocalTime.of(18, 0)), true, 1, "user") };

		for (Schedule schedule : schedules) {
			srepository.save(schedule);
		}

		orepository.save(new Organization("A", "회사", null));
		orepository.save(new Organization("B", "영업본부", "A"));
		orepository.save(new Organization("C", "시스템운영본부", "A"));
		orepository.save(new Organization("D", "영업팀", "B"));
		orepository.save(new Organization("E", "마케팅팀", "B"));
		orepository.save(new Organization("F", "보안팀", "C"));

		String template = MethodUtil.readHtmlFileToString("업무협조");
		drepository.save(new DocumentTemplate(50l, template, "업무협조"));
		
		}
}
