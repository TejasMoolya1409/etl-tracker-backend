package com.etlTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etlTracker.beans.CreateIssueRequest;
import com.etlTracker.entity.Issue;
import com.etlTracker.enums.IssueStatus;
import com.etlTracker.service.IssueService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @PostMapping
    public Issue create(@RequestBody CreateIssueRequest request) {
        return issueService.createIssue(request);
    }

    @GetMapping("/project/{projectId}")
    public List<Issue> getByProject(@PathVariable Long projectId) {
        return issueService.getIssuesByProject(projectId);
    }
    
    @PutMapping("/{id}/status")
    public Issue updateStatus(
            @PathVariable Long id,
            @RequestParam IssueStatus status
    ) {
        return issueService.updateStatus(id, status);
    }
}