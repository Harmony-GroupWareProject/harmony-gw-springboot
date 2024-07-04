package com.harmony.gw.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
// 결재 문서 관리 테이블
public class Approval {
	
	// 결재문서 번호
	@Id
	private Long docIdx;
	
	// 결재문서 양식
	@Column(nullable = false)
	private String docType;
	
	// 결재문서 작성자 id
	@Column(nullable = false)
	private String docCreateId;
	
	// 결재문서 작성자 이름
	@Column(nullable = false)
	private String docCreateName;
	
	// 결재문서 제목
	@Column(nullable = false)
	private String docTitle;
	
	// 결재문서 내용(작성 내용)
	@Column(nullable = false)
	private String docContent;
	
	// 결재문서 수신 참조자
	@Column(nullable = true)
	private String referenceId;
		
	// 결재문서 작성 일자
	@Column(nullable = false)
	private LocalDate createDate;
	
	// 결재문서 최종 결재 완료일자(update 계속)
	@Column(nullable = false)
	private LocalDate completeDate;
	
	// 결재 순서?

}
