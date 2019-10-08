package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Project;
import com.example.demo.repositories.ProjectRepository;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}

	@Override
	public List<Project> getAll() {
		List<Project> projects = (List<Project>) projectRepository.findAll();
		return projects;
	}

	@Override
	public Project getByKey(String projectKey) {
		return projectRepository.findById(projectKey).get();
	}
	
}
