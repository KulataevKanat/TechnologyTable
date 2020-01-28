package kg.CSoft.TechnologyTable.endpoint.project;

import kg.CSoft.TechnologyTable.dto.project.ProjectAccessDto;
import kg.CSoft.TechnologyTable.dto.project.ProjectDto;
import kg.CSoft.TechnologyTable.dto.project.ProjectRequest;

import java.util.List;

public interface ProjectEndpoint {
    ProjectDto addProject(ProjectRequest projectRequest);

    ProjectDto removeProjectById(Long id);

    ProjectDto changeProject(ProjectRequest projectRequest, Long id);

    ProjectDto getProjectById(Long id);

    ProjectAccessDto addAccess(List<String> userAccess, Long id);

    List<ProjectDto> getAllProjects();

}
