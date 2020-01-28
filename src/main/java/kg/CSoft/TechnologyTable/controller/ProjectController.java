package kg.CSoft.TechnologyTable.controller;

import kg.CSoft.TechnologyTable.dto.project.ProjectAccessDto;
import kg.CSoft.TechnologyTable.dto.project.ProjectDto;
import kg.CSoft.TechnologyTable.dto.project.ProjectRequest;
import kg.CSoft.TechnologyTable.endpoint.ProjectEndpoint;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectEndpoint projectEndpoint;
    @Autowired
    private ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectRequest projectRequest) {
        return new ResponseEntity<>(projectEndpoint.addProject(projectRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectDto> removeProjectById(@PathVariable Long id) {
        return new ResponseEntity<>(projectEndpoint.removeProjectById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> changeProject(@RequestBody ProjectRequest projectRequest, @PathVariable Long id) {
        return new ResponseEntity<>(projectEndpoint.changeProject(projectRequest, id), HttpStatus.OK);
    }

    @PutMapping("/addAccess/{id}")
    public ResponseEntity<ProjectAccessDto> addAccess(@RequestBody List<String> userAccess, @PathVariable Long id) {
        return new ResponseEntity<>(projectEndpoint.addAccess(userAccess, id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable Long id) {
        return projectEndpoint.getProjectById(id);

    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectEndpoint.getAllProjects();
    }

}
