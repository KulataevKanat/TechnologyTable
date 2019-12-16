package kg.CSoft.TechnologyTable.dto.role;

import kg.CSoft.TechnologyTable.dto.user.UserDto;
import kg.CSoft.TechnologyTable.entity.Role;
import kg.CSoft.TechnologyTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class RoleDto {
    private Long id;
    private String name;
    private String text;

    public RoleDto(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.text = role.getText();
    }


    public static List<RoleDto> toList(List<Role> list) {
        List<RoleDto> resultList = new LinkedList<>();
        for (Role role : list) {
            resultList.add(new RoleDto(role));
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
