//package kg.CSoft.TechnologyTable.security;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.MalformedJwtException;
////import kg.CSoft.TechnologyTable.service.JwtUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
////    @Autowired
////    private JwtUserDetailsService jwtUserDetailsService;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//        final String requestTokenHeader = request.getHeader("Authorization");
//        String username = null;
//        String jwtToken = null;
//        boolean isRequestNotNeedAuth = request.getRequestURI().equals("/api/register") || request.getRequestURI().equals("/api/login");
//        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ") && !isRequestNotNeedAuth) {
//            jwtToken = requestTokenHeader.substring(7);
//            try {
//                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Unable to get JWT Token");
//            } catch (ExpiredJwtException e) {
//                request.setAttribute("expired", e.getMessage());
//            } catch (MalformedJwtException e) {
//                request.setAttribute("valueError", "Token error, unable tor read JWT");
//            }
//        } else if(requestTokenHeader != null && !isRequestNotNeedAuth && !requestTokenHeader.startsWith("Bearer ")){
//            request.setAttribute("bearerTokenAbsent", "JWT Token does not begin with Bearer String");
//        }

//        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
//        if(userDetails == null) request.setAttribute("userInactive", "User is inactive");
//        else if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken
//                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//        chain.doFilter(request, response);
    //}

//}

