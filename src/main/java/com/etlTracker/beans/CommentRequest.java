package com.etlTracker.beans;

import lombok.Data;

@Data
public class CommentRequest {
    private String message;
    private Long issueId;
    private Long userId;
}
