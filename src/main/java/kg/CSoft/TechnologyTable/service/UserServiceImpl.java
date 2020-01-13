package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.entry.User;
import kg.CSoft.TechnologyTable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.ldap.LdapName;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private LdapTemplate ldapTemplate;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
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
    public Optional<User> findByUsername(String username) {
//        return ldapTemplate.find(LdapQueryBuilder.query().where("userPrincipalName").is(username), User.class);
        return userRepository.findByUsername(username);
    }

}

