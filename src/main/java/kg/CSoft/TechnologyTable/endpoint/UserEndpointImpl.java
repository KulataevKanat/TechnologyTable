package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.user.UserDto;
import kg.CSoft.TechnologyTable.entry.User;
import kg.CSoft.TechnologyTable.security.JwtTokenUtil;
import kg.CSoft.TechnologyTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import javax.naming.ldap.LdapName;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@Service
public class UserEndpointImpl implements UserEndpoint {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public List<UserDto> getAll() {
        return UserDto.toList(userService.getAll());
    }

    @Override
    public List<User> getByLogin(String login) {
        return userService.getByLogin(login);
    }

//    @Override
//    public ResponseEntity<Object> getToken(UserAuthorizationRequest authorizationRequest) {
//        String result;
//        try {
//            result = userService.getToken(authorizationRequest);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(new ObjectMessage(e.getMessage()), HttpStatus.NOT_FOUND);
//        }
//        if (result.equals("Bad credentials"))
//            return new ResponseEntity<>(new ObjectMessage("Bad credentials"), HttpStatus.UNAUTHORIZED);
//        return new ResponseEntity<>(new UserAndToken(userService.getByLogin(authorizationRequest.getLogin()), result), HttpStatus.OK);
//    }


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

