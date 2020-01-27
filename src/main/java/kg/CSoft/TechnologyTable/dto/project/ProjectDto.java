package kg.CSoft.TechnologyTable.dto.project;

import kg.CSoft.TechnologyTable.entity.Project;

import java.util.LinkedList;
import java.util.List;

public class ProjectDto {
    private Long id;
    private String name;
    private String description;

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
    }

    public static List<ProjectDto> toList(List<Project> list) {
        List<ProjectDto> resultList = new LinkedList<>();
        for (Project project : list) {
            resultList.add(new ProjectDto(project));
        }
        return resultList;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
