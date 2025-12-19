package com.etlTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etlTracker.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
