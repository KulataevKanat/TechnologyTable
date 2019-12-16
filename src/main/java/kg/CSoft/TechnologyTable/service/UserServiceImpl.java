package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.dto.user.UserAuthorizationRequest;
import kg.CSoft.TechnologyTable.entry.User;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private LdapTemplate ldapTemplate;

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
        ldapTemplate.
        return ldapTemplate.find(LdapQueryBuilder.query().where("cn").is(cn), User.class);
    }

    @Override
    public List<User> getByLogin(String login) {
        return ldapTemplate.find(LdapQueryBuilder.query().where("userPrincipalName").is(login), User.class);
    }

    @Override
    public List<String> getUserGroups(String sAMAccountName) {
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

//    @Override
//    @Transactional(readOnly = true)
//    public String getToken(UserAuthorizationRequest authorizationRequest) {
//        List<User> user = getByLogin(authorizationRequest.getLogin());
//        if (user == null)
//            return "User is doesn't exist";
//        if (encoder.matches(authorizationRequest.getPassword(), user.iterator().next().getPassword())) {
//            String loginPassPair = authorizationRequest.getLogin() + ":" + authorizationRequest.getPassword();
//            String token = Base64.getEncoder().encodeToString(loginPassPair.getBytes());
//            return "Basic " + token;
//        }
//        return "Bad credentials";
//    }


}

