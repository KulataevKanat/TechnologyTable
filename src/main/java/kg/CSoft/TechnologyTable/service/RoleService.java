package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    Role addAccess(Role role);

    Role getById(Long id);

    Role getByName(String name);

    Role create(Role role);

    Role update(Role role);

    Role deleteById(Long id);


}
