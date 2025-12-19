package com.etlTracker.beans;

import com.etlTracker.enums.Priority;

import lombok.Data;

@Data
public class CreateIssueRequest {
    private String title;
    private String description;
    private Priority priority;
    private Long projectId;
    private Long createdBy;
    private Long assignedTo;
}