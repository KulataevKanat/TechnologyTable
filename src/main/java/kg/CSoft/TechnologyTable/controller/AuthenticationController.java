package kg.CSoft.TechnologyTable.controller;

import kg.CSoft.TechnologyTable.dto.user.AuthenticationRequest;
import kg.CSoft.TechnologyTable.endpoint.user.UserEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class AuthenticationController {
    @Autowired
    private UserEndpoint userEndpoint;

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody AuthenticationRequest data) {
        return userEndpoint.signIn(data);

    }
}
