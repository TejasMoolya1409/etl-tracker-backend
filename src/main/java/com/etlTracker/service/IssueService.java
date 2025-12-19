package com.etlTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etlTracker.beans.CreateIssueRequest;
import com.etlTracker.entity.Issue;
import com.etlTracker.enums.IssueStatus;
import com.etlTracker.repository.IssueRepository;
import com.etlTracker.repository.ProjectRepository;
import com.etlTracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {

	private final IssueRepository issueRepository;
	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;

	public Issue createIssue(CreateIssueRequest request) {

		Issue issue = new Issue();
		issue.setTitle(request.getTitle());
		issue.setDescription(request.getDescription());
		issue.setPriority(request.getPriority());
		issue.setStatus(IssueStatus.TO_DO);

		issue.setProject(projectRepository.findById(request.getProjectId()).orElseThrow());
		issue.setCreatedBy(userRepository.findById(request.getCreatedBy()).orElseThrow());
		issue.setAssignedTo(userRepository.findById(request.getAssignedTo()).orElseThrow());

		return issueRepository.save(issue);
	}

	public List<Issue> getIssuesByProject(Long projectId) {
		return issueRepository.findByProjectId(projectId);
	}

	public Issue updateStatus(Long issueId, IssueStatus status) {
		Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new RuntimeException("Issue not found"));

		issue.setStatus(status);
		return issueRepository.save(issue);
	}
}
