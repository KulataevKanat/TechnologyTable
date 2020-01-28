package kg.CSoft.TechnologyTable.service.user;

import kg.CSoft.TechnologyTable.entry.User;
import kg.CSoft.TechnologyTable.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import javax.naming.ldap.LdapName;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public List<User> getAll() {
        return ldapTemplate.findAll(User.class);
    }

    @Override
    public User findByDn(LdapName dn) {
        return ldapTemplate.findByDn(dn, User.class);
    }

    @Override
    public List<User> findByCn(String cn) {
        return ldapTemplate.find(LdapQueryBuilder.query().where("cn").is(cn), User.class);
    }

    @Override
    public List<User> findByUsername(String username) {
        return ldapTemplate.find(LdapQueryBuilder.query().where("sAMAccountName").is(username), User.class);
    }
}

