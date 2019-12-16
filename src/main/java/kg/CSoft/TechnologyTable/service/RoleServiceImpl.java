package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.entity.Role;
import kg.CSoft.TechnologyTable.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role addAccess(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Couldn't find role with id " + id));
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Couldn't find role with name " + name));
    }

    @Override
    @Transactional
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role deleteById(Long id) {
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }
}
