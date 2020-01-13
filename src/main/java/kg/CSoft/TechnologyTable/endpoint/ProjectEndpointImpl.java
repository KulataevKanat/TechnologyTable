package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.project.*;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.entry.User;
import kg.CSoft.TechnologyTable.service.ProjectService;
import kg.CSoft.TechnologyTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectEndpointImpl implements ProjectEndpoint {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @Override

    public ProjectDto addProject(ProjectRequest projectRequest) {
        Project project = new Project(projectRequest.getName(), projectRequest.getDescription());
        projectService.addProject(project);
        return new ProjectDto(project);
    }

    @Override
    public ProjectDto removeProjectById(Long id) {
        return projectService.removeProjectById(id);

    }

    @Override
    public ProjectDto changeProject(ProjectRequest projectRequest, Long id) {
        Project project = projectService.getProjectById(id);
        if (projectRequest.getName() != null) project.setName(projectRequest.getName());
        if (projectRequest.getDescription() != null) project.setDescription(projectRequest.getDescription());
        projectService.changeProject(project);
        return new ProjectDto(project);
    }

    @Override
    public ProjectDto getProjectById(Long id) {
        return new ProjectDto(projectService.getProjectById(id));
    }

    @Override
    public ProjectAccessDto addAccess(List<String> userAccess, Long id) {
        Project project = projectService.getProjectById(id);

        Set<String> cnList = new HashSet<>();
        userAccess.forEach(element -> {
            cnList.add(userService.findByCn(element).get(0).getCn());
        });

        List<User> userList = new ArrayList<>();
        cnList.forEach(element -> {
            userList.add(userService.findByCn(element).get(0));
        });

        project.setCnList(cnList);
        projectService.addAccess(project);
        return new ProjectAccessDto(project, userList);

    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return ProjectDto.toList(projectService.getAllProjects());
    }

}
