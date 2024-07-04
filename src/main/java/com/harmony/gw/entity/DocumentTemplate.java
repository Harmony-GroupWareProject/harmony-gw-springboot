package com.harmony.gw.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "document_template")
@SequenceGenerator(name = "template_seq", sequenceName = "template_seq", allocationSize = 1)
public class DocumentTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_seq")
    private Long id;

    private String name;

    @Lob
    private String content;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
