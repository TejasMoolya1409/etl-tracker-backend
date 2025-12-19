package com.etlTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etlTracker.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByProjectId(Long projectId);
}
