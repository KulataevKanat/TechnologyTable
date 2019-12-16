package kg.CSoft.TechnologyTable.dto.role;

import kg.CSoft.TechnologyTable.entity.Role;
import kg.CSoft.TechnologyTable.entry.User;

import java.util.List;

public class UserRoleDto {
    private Long id;
    private String name;
    private String text;
    private List<User> users;

    public UserRoleDto(Role role, List<User> userList) {
        this.id = role.getId();
        this.name = role.getName();
        this.text = role.getText();
        this.users = userList;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
