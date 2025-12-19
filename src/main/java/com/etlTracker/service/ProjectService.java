package com.etlTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etlTracker.beans.CreateProjectRequest;
import com.etlTracker.entity.Project;
import com.etlTracker.entity.User;
import com.etlTracker.repository.ProjectRepository;
import com.etlTracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;

	public Project createProject(CreateProjectRequest request) {

		User user = userRepository.findById(request.getCreatedByUserId()).orElseThrow();

		Project project = new Project();
		project.setName(request.getName());
		project.setDescription(request.getDescription());
		project.setCreatedBy(user);

		return projectRepository.save(project);
	}

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}
}