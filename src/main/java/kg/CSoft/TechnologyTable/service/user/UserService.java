package kg.CSoft.TechnologyTable.service.user;


import kg.CSoft.TechnologyTable.entry.User;

import javax.naming.ldap.LdapName;
import java.util.List;

public interface UserService {
    List<User> getAll();

    User findByDn(LdapName dn);

    List<User> findByCn(String cn);

    List<User> findByUsername(String username);

}
