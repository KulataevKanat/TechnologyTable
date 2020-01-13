package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.user.AuthenticationRequest;
import kg.CSoft.TechnologyTable.dto.user.UserDto;
import kg.CSoft.TechnologyTable.repository.UserRepository;
import kg.CSoft.TechnologyTable.security.JwtTokenProvider;
import kg.CSoft.TechnologyTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.ldap.LdapName;
import java.util.*;

import static org.springframework.http.ResponseEntity.ok;


@Service
public class UserEndpointImpl implements UserEndpoint {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        return UserDto.toList(userService.getAll());
    }

    @Override
    public ResponseEntity<?> signIn(AuthenticationRequest data) {
        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());

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
    public List getUserGroups(String sAMAccountName) {
        EqualsFilter filter = new EqualsFilter("sAMAccountName", sAMAccountName);
        return ldapTemplate.search(DistinguishedName.EMPTY_PATH, filter.encode(), new AttributesMapper() {
            public Object mapFromAttributes(javax.naming.directory.Attributes attrs) throws javax.naming.NamingException {
                List<String> memberOf = new ArrayList();
                for (Enumeration vals = attrs.get("memberOf").getAll(); vals.hasMoreElements(); ) {
                    memberOf.add((String) vals.nextElement());
                }
                return memberOf;
            }
        });

    }
}

