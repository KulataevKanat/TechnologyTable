//package kg.CSoft.TechnologyTable.service;
//
//import kg.CSoft.TechnologyTable.dto.user.UserAndToken;
//import kg.CSoft.TechnologyTable.dto.user.UserAuthorizationRequest;
//import kg.CSoft.TechnologyTable.endpoint.UserEndpoint;
//import kg.CSoft.TechnologyTable.entry.User;
//import kg.CSoft.TechnologyTable.security.JwtTokenUtil;
//import org.apache.logging.log4j.message.ObjectMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Service
//public class JwtAuthServiceImpl implements JwtAuthService {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
////    @Autowired
////    private JwtUserDetailsService userDetailsService;
////    @Autowired
////    private UserEndpoint userEndpoint;
////
////    @Override
////    public ResponseEntity<?> getToken(UserAuthorizationRequest authenticationRequest) throws Exception {
////        List<User> user;
////        try {
////            user = userEndpoint.getByLogin(authenticationRequest.getLogin());
////        } catch (NoSuchElementException e) {
////            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
////        }
////        authenticate(authenticationRequest.getLogin(), authenticationRequest.getPassword());
////        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getLogin());
////        final String token = jwtTokenUtil.generateToken(userDetails);
////
////        return ResponseEntity.ok(new UserAndToken(user, token));
////    }
//
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//
//
//}
