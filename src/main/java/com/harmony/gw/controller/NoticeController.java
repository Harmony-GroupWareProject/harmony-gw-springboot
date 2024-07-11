package com.harmony.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.entity.Notice;
import com.harmony.gw.service.NoticeServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class NoticeController {
    
    @Autowired
    private NoticeServiceImpl noticeService;
    
    @GetMapping("/notice/list")
    public Page<Notice> getNotices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return noticeService.getNotices(page, size);
    }
    
    @PostMapping("/notice/save")
    public void saveNotice(@RequestBody Notice notice) {
    	noticeService.saveNotice(notice);
    }
}
