package com.etlTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etlTracker.beans.CreateProjectRequest;
import com.etlTracker.entity.Project;
import com.etlTracker.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public Project create(@RequestBody CreateProjectRequest request) {
        return projectService.createProject(request);
    }

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAllProjects();
    }
}