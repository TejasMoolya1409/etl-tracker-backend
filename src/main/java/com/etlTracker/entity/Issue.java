package com.etlTracker.entity;

import com.etlTracker.enums.IssueStatus;
import com.etlTracker.enums.Priority;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="issues")
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;

	@Enumerated(EnumType.STRING)
	private IssueStatus status;

	@Enumerated(EnumType.STRING)
	private Priority priority;

	@ManyToOne
	private Project project;

	@ManyToOne
	private User assignedTo;

	@ManyToOne
	private User createdBy;
}