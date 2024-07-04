package com.harmony.gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harmony.gw.entity.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {

}
