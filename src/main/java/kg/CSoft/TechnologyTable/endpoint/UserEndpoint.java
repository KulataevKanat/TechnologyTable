package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.user.*;
import kg.CSoft.TechnologyTable.entry.User;
import org.springframework.http.ResponseEntity;

import javax.naming.ldap.LdapName;
import java.util.List;

public interface UserEndpoint {
    List<UserDto> getAll();

    List<User> getByLogin(String login);

//    ResponseEntity<Object> getToken(UserAuthorizationRequest authorizationRequest);

    UserDto findByDn(LdapName dn);

    List<UserDto> findByCn(String cn);

    List getUserGroups(String sAMAccountName);

}