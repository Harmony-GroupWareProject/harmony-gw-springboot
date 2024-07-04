package com.harmony.gw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.entity.DocumentTemplate;
import com.harmony.gw.service.DocumentTemplateServiceImpl;

@RestController
@RequestMapping("/templates")
public class DocumentTemplateController {
    @Autowired
    private DocumentTemplateServiceImpl service;

    @GetMapping
    public List<DocumentTemplate> getAllTemplates() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DocumentTemplate> getTemplateById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DocumentTemplate createTemplate(@RequestBody DocumentTemplate template) {
        return service.save(template);
    }
}
