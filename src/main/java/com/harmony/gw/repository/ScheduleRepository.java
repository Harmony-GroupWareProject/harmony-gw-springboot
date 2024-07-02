package com.harmony.gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harmony.gw.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
