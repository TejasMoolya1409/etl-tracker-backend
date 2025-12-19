package com.etlTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etlTracker.beans.CommentRequest;
import com.etlTracker.entity.Comment;
import com.etlTracker.repository.CommentRepository;
import com.etlTracker.repository.IssueRepository;
import com.etlTracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    public Comment addComment(CommentRequest request) {

        Comment comment = new Comment();
        comment.setMessage(request.getMessage());
        comment.setIssue(issueRepository.findById(request.getIssueId()).orElseThrow());
        comment.setUser(userRepository.findById(request.getUserId()).orElseThrow());

        return commentRepository.save(comment);
    }

    public List<Comment> getComments(Long issueId) {
        return commentRepository.findByIssueId(issueId);
    }
}