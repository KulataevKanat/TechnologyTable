package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.user.*;
import org.springframework.http.ResponseEntity;

import javax.naming.ldap.LdapName;
import java.util.List;

public interface UserEndpoint {
    List<UserDto> getAll();

    ResponseEntity<?> signIn(AuthenticationRequest data);

    UserDto findByDn(LdapName dn);

    List<UserDto> findByCn(String cn);

    List getUserGroups(String sAMAccountName);

}
