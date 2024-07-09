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

@Table(name = "approver")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "approver_seq", sequenceName = "approver_seq", allocationSize = 1)
public class Approver {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "approver_seq")
    private Long code;

    // ApprovalBoard의 code 필드와 연관된 결재 문서 ID
	@ManyToOne
	@JoinColumn(name = "approvalDoc", nullable = false)
	@ToString.Exclude
    private ApprovalDoc approvalDoc;
    
    // 결재자 ID
    private String id;
    
    // 결재 순서
    private int turn;
    
    // 결재 상태 (미결재, 결재 등)
    private String state;
    
    // 마지막 결재자인지 여부
    private boolean lastTurn;

	public Approver(ApprovalDoc approvalDoc, String id, int turn, String state, boolean lastTurn) {
		this.approvalDoc = approvalDoc;
		this.id = id;
		this.turn = turn;
		this.state = state;
		this.lastTurn = lastTurn;
	}
	
    
}
