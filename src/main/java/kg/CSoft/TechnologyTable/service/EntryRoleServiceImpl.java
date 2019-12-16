package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.entry.EntryRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryRoleServiceImpl implements EntryRoleService {
    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public List<EntryRole> findAll() {
        return ldapTemplate.findAll(EntryRole.class);
    }
}
