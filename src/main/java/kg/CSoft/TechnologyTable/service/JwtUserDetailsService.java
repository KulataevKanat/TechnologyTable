package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = userService.getByLogin(username);
        if (user == null) {
            return null;
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        GrantedAuthority grantedAuthority = (GrantedAuthority) () -> user.iterator().next().getLogin();
        roles.add(grantedAuthority);
        return new org.springframework.security.core.userdetails.User(user.iterator().next().getLogin(), user.iterator().next().getPassword(),
                roles);
    }

}
