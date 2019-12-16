package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.dto.project.ProjectAccessDto;
import kg.CSoft.TechnologyTable.dto.project.ProjectDto;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project addAccess(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public ProjectDto removeProjectById(Long id) {
        projectRepository.deleteById(id);
        return null;
    }


    @Override
    public Project changeProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> projectSearchByName(String name) {
        return projectRepository.projectSearchByName(name);
    }
}
