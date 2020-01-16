package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.dto.project.ProjectDto;
import kg.CSoft.TechnologyTable.entity.Project;

import java.util.List;

public interface ProjectService {

    Project addProject(Project project);

    Project addAccess(Project project);

    ProjectDto removeProjectById(Long id);

    Project changeProject(Project project);

    Project getProjectById(Long id);

    List<Project> getAllProjects();
}
