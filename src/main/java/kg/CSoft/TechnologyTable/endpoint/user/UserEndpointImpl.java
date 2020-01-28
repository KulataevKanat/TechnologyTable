package kg.CSoft.TechnologyTable.endpoint.user;

import kg.CSoft.TechnologyTable.dto.user.AuthenticationRequest;
import kg.CSoft.TechnologyTable.dto.user.UserDto;
import kg.CSoft.TechnologyTable.security.JwtTokenProvider;
import kg.CSoft.TechnologyTable.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.ldap.LdapName;
import javax.validation.constraints.NotNull;
import java.util.*;

import static org.springframework.http.ResponseEntity.ok;


@Service
public class UserEndpointImpl implements UserEndpoint {
    @Autowired
    private UserService userService;

    @Value("${ldap.base.dn}")
    private String AD_BASE_DN;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public List<UserDto> getAll() {
        return UserDto.toList(userService.getAll());
    }

    @Override
    public ResponseEntity<?> signIn(AuthenticationRequest data) {
        String username = data.getUsername();
        ldapTemplate.authenticate((LdapQueryBuilder.query().where("sAMAccountName").is(username)), data.getPassword());
        String token = jwtTokenProvider.createToken(username, userService.findByUsername(username).get(0).getRoles());
        Map<Object, Object> model = new HashMap<>();
        model.put("username", username);
        model.put("token", token);
        return ok(model);

    }

    @Override
    public UserDto findByDn(LdapName dn) {
        return new UserDto(userService.findByDn(dn));
    }

    @Override
    public List<UserDto> findByCn(String cn) {
        return UserDto.toList(userService.findByCn(cn));
    }

    @Override
    public List<UserDto> findByUsername(String username) {
        return UserDto.toList(userService.findByUsername(username));
    }
}

