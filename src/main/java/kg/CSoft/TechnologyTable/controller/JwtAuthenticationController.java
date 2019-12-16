//package kg.CSoft.TechnologyTable.controller;
//
//import kg.CSoft.TechnologyTable.dto.user.UserAuthorizationRequest;
//import kg.CSoft.TechnologyTable.endpoint.UserEndpoint;
//import kg.CSoft.TechnologyTable.service.JwtAuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/user")
//public class JwtAuthenticationController {
//    @Autowired
//    private JwtAuthService jwtAuthService;
//
//    @PostMapping("/authentication")
//    public ResponseEntity<?> getToken(@RequestBody UserAuthorizationRequest authenticationRequest) throws Exception {
//        return jwtAuthService.getToken(authenticationRequest);
//    }

//}
