package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.impl.AccountDoesNotExistException;
import fr.eql.ai113.ifidieback.service.impl.AccountExistException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;

public interface UserService extends UserDetailsService {
    Authentication authenticate (String username, String password) throws AuthenticationException;
    UserDetails save(String username, String password, String lastname, String surname) throws AccountExistException;

    UserDetails saveFull(String username, String password, String lastname, String surname, int addressNb, String addressStreetName,
                         String country, String city, String phoneNumber, LocalDate birthDate) throws AccountExistException;

    User trustedPersonAffect(User client, String username) throws AccountDoesNotExistException;

    String generateJWTforUser (UserDetails user);
    UserDetails getUserFromJWT (String jwt);



}
