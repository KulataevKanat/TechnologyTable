package kg.CSoft.TechnologyTable.dto.project;

import kg.CSoft.TechnologyTable.entity.Project;

public class ProjectRequest {
    private String name;
    private String description;

    public ProjectRequest() {
    }

    public ProjectRequest(Project project) {
        this.name = project.getName();
        this.description = project.getDescription();
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
