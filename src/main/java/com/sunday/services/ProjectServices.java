package com.sunday.services;

import com.sunday.domain.Project;
import com.sunday.exceptions.ProjectIdException;
import com.sunday.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServices {

    private final ProjectRepository repository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return repository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId) {

        Project project = repository.findByProjectIdentifier(projectId);
        if (project == null)
            throw new ProjectIdException("Project ID '" + projectId.toUpperCase() + "' does not exists");
        return project;
    }

    public Iterable<Project> findAllProjects() {
        return repository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {
        Project project = repository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Cannot Project with ID '" + projectId.toUpperCase() + "' This does not exist");
        }
        repository.delete(project);
    }

}
