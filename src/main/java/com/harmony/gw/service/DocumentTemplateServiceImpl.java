package com.harmony.gw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmony.gw.entity.DocumentTemplate;
import com.harmony.gw.repository.DocumentTemplateRepository;

@Service
public class DocumentTemplateServiceImpl {
    @Autowired
    private DocumentTemplateRepository repository;

    public List<DocumentTemplate> findAll() {
        return repository.findAll();
    }

    public Optional<DocumentTemplate> findById(Long id) {
        return repository.findById(id);
    }

    public DocumentTemplate save(DocumentTemplate template) {
        return repository.save(template);
    }
}
