package kg.CSoft.TechnologyTable.security;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        List<String> attributes = new ArrayList<>(Collections.list(request.getAttributeNames()));
        boolean isSent = false;
        for (String s : attributes) {
            if (s.equals("expired")) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, (String) request.getAttribute(s));
                isSent = true;
                break;
            }
            if (s.equals("valueError")){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, (String) request.getAttribute(s));
                isSent = true;
                break;
            }
            if(s.equals("bearerTokenAbsent")) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, (String) request.getAttribute(s));
                isSent = true;
                break;
            }
            if(s.equals("userInactive")) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User is inactive");
                isSent = true;
                break;
            }
        }
        if(!isSent) response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

}
