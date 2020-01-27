package kg.CSoft.TechnologyTable.dto.project;

import kg.CSoft.TechnologyTable.dto.host.HostDto;
import kg.CSoft.TechnologyTable.entity.Host;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.entry.User;

import java.util.LinkedList;
import java.util.List;

public class ProjectAccessDto {
    private Long id;
    private String name;
    private String description;
    private List<User> userList;

    public ProjectAccessDto(Project project, List<User> userList) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
        this.userList = userList;
    }

    public static List<HostDto> toList(List<Host> list) {
        List<HostDto> resultList = new LinkedList<>();
        for (Host host : list) {
            resultList.add(new HostDto(host));
        }
        return resultList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
