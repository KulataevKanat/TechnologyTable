package kg.CSoft.TechnologyTable.service;


import kg.CSoft.TechnologyTable.dto.user.UserAuthorizationRequest;
import kg.CSoft.TechnologyTable.entry.User;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;

import javax.naming.ldap.LdapName;
import java.util.List;

public interface UserService {
    List<User> getAll();

    User findByDn(LdapName dn);

    List<User> findByCn(String cn);

    List<User> getByLogin(String login);

//    String getToken(UserAuthorizationRequest authorizationRequest);

    List<String> getUserGroups(String sAMAccountName);


}
