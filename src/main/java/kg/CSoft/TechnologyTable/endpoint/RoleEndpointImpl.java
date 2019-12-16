package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.role.EntryRoleDto;
import kg.CSoft.TechnologyTable.dto.role.RoleDto;
import kg.CSoft.TechnologyTable.dto.role.UserRoleDto;
import kg.CSoft.TechnologyTable.entity.Role;
import kg.CSoft.TechnologyTable.service.EntryRoleService;
import kg.CSoft.TechnologyTable.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleEndpointImpl implements RoleEndpoint {
    @Autowired
    private RoleService roleService;
    @Autowired
    private EntryRoleService entryRoleService;

    @Override
    public List<RoleDto> getAllRoles() {
        return RoleDto.toList(roleService.getAll());
    }

    @Override
    public List<EntryRoleDto> findAllRoles() {
        return EntryRoleDto.toList(entryRoleService.findAll());
    }

    @Override
    public RoleDto getRoleById(Long id) {
        return new RoleDto(roleService.getById(id));
    }

    @Override
    public RoleDto getByName(String name) {
        return new RoleDto(roleService.getByName(name));
    }

    @Override
    public RoleDto create(RoleDto roleRequest) {
        Role role = new Role(roleRequest.getName(), roleRequest.getText());
        return new RoleDto(roleService.create(role));
    }

    @Override
    public UserRoleDto addUserRole(List<String> userCn, Long roleId) {
        return null;
    }

    @Override
    public RoleDto update(RoleDto roleRequest, Long id) {
        return null;
    }

    @Override
    public RoleDto deleteById(Long id) {
        return null;
    }
}
