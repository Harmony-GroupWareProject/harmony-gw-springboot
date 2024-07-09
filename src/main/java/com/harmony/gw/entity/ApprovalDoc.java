package com.harmony.gw.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
// 결재 문서 관리 테이블
public class ApprovalDoc {
	
	// 결재문서 번호
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "com.harmony.gw.entity.IdGenerator")
	@GeneratedValue(generator = "idGenerator")
	private String docIdx;
	
	// 결재문서 양식
	@Column(nullable = false)
	private String docType;
	
	// 결재문서 작성자 id
	@ManyToOne
	@JoinColumn(name = "writer", nullable = false)
	@ToString.Exclude
	private Employee employee;
	
	// 결재문서 제목
	@Column(nullable = false)
	private String docTitle;
	
	// 결재문서 내용(작성 내용)
	@Column(nullable = false)
	private String docContent;
			
	// 결재문서 작성 일자
	@Column(nullable = true)
	private LocalDate createDate;
	
	// 결재문서 최종 결재 완료일자(update 계속)
	@Column(nullable = true)
	private LocalDate completeDate;

}
