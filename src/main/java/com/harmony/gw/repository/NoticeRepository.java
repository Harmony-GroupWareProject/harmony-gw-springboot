package com.harmony.gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harmony.gw.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
