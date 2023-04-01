package fr.eql.ai113.ifidieback.security;

import fr.eql.ai113.ifidieback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter  extends OncePerRequestFilter {

    /**Injecté par le setter**/
    private UserService userService;


    /**
     * This method is an implementation of the OncePerRequest class, it ensures that this filter logic is only executed
     * once per request.
     * @param request Authentification
     * @param response Do I match the token ?
     * @param filterChain FilterChain javax servlet
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            String token = extractTokenFromHeader(request); // Calls internal method
            UserDetails user = userService.getUserFromJWT(token); // Token gives us a User (UserDetails)
            setPrincipalInsecurityContext(user); // Calls internal method that put token in context
        }catch (Exception e){
            logger.info("Impossible de trouver le token " + e);
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Internal method called by doFilterInternal
     * @param request the http request
     * @return if a token is present, it returns the token, otherwise returns null
     */
    private String extractTokenFromHeader(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        //Spécifiquement le mot clé "Authorization" pour récupérer le token
        if(bearerToken != null){
            return bearerToken.substring(7); // Parce que c'est là qu'est le token dans le header
        }
        return null;
    }

    /**
     * Internal method called by doFilterInternal
     * Authentification is successful, the token  is put in security context and will be accessible by every tools in app
     * @param user UserDetail
     */
    private void setPrincipalInsecurityContext(UserDetails user) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(token);
    }


    //Setter
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



}
