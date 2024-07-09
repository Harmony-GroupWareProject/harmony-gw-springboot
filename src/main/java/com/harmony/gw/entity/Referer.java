package com.harmony.gw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "referer")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "referer_seq", sequenceName = "referer_seq", allocationSize = 1)
public class Referer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referer_seq")
    private Long code;

    // ApprovalBoard의 code 필드와 연관된 결재 문서 ID
	@ManyToOne
	@JoinColumn(name = "approvalDoc", nullable = false)
	@ToString.Exclude
    private ApprovalDoc approvalDoc;
    
    // 결재자 ID
    private String id;

	public Referer(ApprovalDoc approvalDoc, String id) {
		super();
		this.approvalDoc = approvalDoc;
		this.id = id;
	}
    
    
	
}