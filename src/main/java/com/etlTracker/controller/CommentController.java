package com.etlTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etlTracker.beans.CommentRequest;
import com.etlTracker.entity.Comment;
import com.etlTracker.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Comment add(@RequestBody CommentRequest request) {
        return commentService.addComment(request);
    }

    @GetMapping("/issue/{issueId}")
    public List<Comment> get(@PathVariable Long issueId) {
        return commentService.getComments(issueId);
    }
}