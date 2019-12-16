package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.role.EntryRoleDto;
import kg.CSoft.TechnologyTable.dto.role.RoleDto;
import kg.CSoft.TechnologyTable.dto.role.UserRoleDto;
import kg.CSoft.TechnologyTable.entry.EntryRole;

import java.util.List;

public interface RoleEndpoint {

    List<RoleDto> getAllRoles();

    List<EntryRoleDto> findAllRoles();

    RoleDto getRoleById(Long id);

    RoleDto getByName(String name);

    RoleDto create(RoleDto roleRequest);

    UserRoleDto addUserRole(List<String> userCn, Long roleId);

    RoleDto update(RoleDto roleRequest, Long id);

    RoleDto deleteById(Long id);


}
