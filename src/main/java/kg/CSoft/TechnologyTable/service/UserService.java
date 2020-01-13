package kg.CSoft.TechnologyTable.service;


import kg.CSoft.TechnologyTable.entry.User;

import javax.naming.ldap.LdapName;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    User findByDn(LdapName dn);

    List<User> findByCn(String cn);

    Optional<User> findByUsername(String username);

}
