package com.harmony.gw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.harmony.gw.entity.ApprovalDoc;

@EnableJpaRepositories
public interface ApprovalDocRepository extends JpaRepository<ApprovalDoc, String> {
    List<ApprovalDoc> findByEmployeeEmpNo(String empNo);
    ApprovalDoc findByDocIdx(String docIdx);
}
