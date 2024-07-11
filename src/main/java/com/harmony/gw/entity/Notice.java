package com.harmony.gw.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "notice")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "notice_seq", sequenceName = "notice_seq", allocationSize = 1)
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq")
    private Long noticeIdx;

	@ManyToOne
	@JoinColumn(name = "writer", nullable = false)
	@ToString.Exclude
    private Employee empNo;
    
	@Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String content;
    
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate createDate;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate updateDate;
}
