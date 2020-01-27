package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.user.AuthenticationRequest;
import kg.CSoft.TechnologyTable.dto.user.UserDto;
import kg.CSoft.TechnologyTable.entry.User;
import kg.CSoft.TechnologyTable.security.JwtTokenProvider;
import kg.CSoft.TechnologyTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.naming.ldap.LdapName;
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
        try {
            String username = data.getUsername();
            Filter filter = new EqualsFilter("sAMAccountName", username);
            ldapTemplate.authenticate(AD_BASE_DN, filter.encode(), data.getPassword());
            String token = jwtTokenProvider.createToken(username, userService.findByUsername(username).get(0).getRoles());
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
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

