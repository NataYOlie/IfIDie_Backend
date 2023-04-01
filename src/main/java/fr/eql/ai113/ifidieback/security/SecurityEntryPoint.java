package fr.eql.ai113.ifidieback.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityEntryPoint implements AuthenticationEntryPoint {

    /**
     * This method is an implementation of AuthenticationEntryPoint and is called when an authentication failure occurs.
     * The AuthenticationEntryPoint implementation is responsible for handling the authentication exception and sending
     * an appropriate response to the user.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param authException AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        //Erreur 401
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

    }
}

