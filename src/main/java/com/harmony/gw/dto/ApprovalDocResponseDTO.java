package com.harmony.gw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalDocResponseDTO {
	// 결재문서 양식
//	private String docType;
	
	// 결재문서 작성자 이름
	private String writer;
	
	// 결재문서 제목
	private String docTitle;
	
	// 결재문서 내용(작성 내용)
	private String docContent;
	
	// 결재문서 수신 참조자
//	private String references;
	
	// 결재자
//	private String approvers;
}
