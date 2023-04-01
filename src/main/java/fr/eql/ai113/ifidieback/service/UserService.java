package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.impl.AccountExistException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Authentication authenticate (String username, String password) throws AuthenticationException;
    UserDetails save(String username, String password, String lastname, String surname) throws AccountExistException;
    String generateJWTforUser (UserDetails user);
    UserDetails getUserFromJWT (String jwt);
    User trustedPersonAffect(User client, String name, String surname, String email);

}
