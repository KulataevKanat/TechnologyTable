package kg.CSoft.TechnologyTable.controller;

import kg.CSoft.TechnologyTable.dto.user.*;
import kg.CSoft.TechnologyTable.endpoint.user.UserEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.LdapName;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserEndpoint userEndpoint;

    @GetMapping
    public List<UserDto> getAll() {
        return userEndpoint.getAll();
    }

    @GetMapping("/findByDn/{dn}")
    public UserDto findByDn(@PathVariable LdapName dn) {
        return userEndpoint.findByDn(dn);
    }

    @GetMapping("/findByCn/{cn}")
    public List<UserDto> findByCn(@PathVariable String cn) {
        return userEndpoint.findByCn(cn);
    }

    @GetMapping("/findByUsername")
    public List<UserDto> findByUsername(@RequestParam String username) {
        return userEndpoint.findByUsername(username);
    }
}
