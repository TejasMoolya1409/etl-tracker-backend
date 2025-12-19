package com.etlTracker.beans;

import lombok.Data;

@Data
public class CreateProjectRequest {
    private String name;
    private String description;
    private Long createdByUserId;
}