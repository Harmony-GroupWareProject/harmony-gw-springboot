package com.harmony.gw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.harmony.gw.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule findByScheduleIdx(Long scheduleIdx);
    @Query("SELECT s FROM Schedule s WHERE s.empNo = :empNo AND s.scheduleType = 2")
    List<Schedule> findByEmpNo(String empNo);
}
