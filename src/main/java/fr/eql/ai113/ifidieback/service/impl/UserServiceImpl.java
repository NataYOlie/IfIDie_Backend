package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.repository.UserDao;
import fr.eql.ai113.ifidieback.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Configuration //On le met pour aider Spring à trouver le @Bean du PasswordEncoder
public class UserServiceImpl implements UserService {

    /** Injectée par le setter */
    private UserDao userDao;

    /** Injectée par le setter */
    private AuthenticationManager authenticationManager;

    //Peut être inutile dis Axel
    private final String signingKey;

    //cette valeur fait référence à un attribut de l'application.properties
    public UserServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    //Pour encrypter les mots de passes. On injecte avec @Bean
    /**
     * This method encrypt password in Bcrypt
     * BCrypt Algorithm is used to hash and salt passwords securely.
     * BCrypt permits building a password security stage that can advance nearby hardware innovation to guard against
     * dangers or threats in the long run, like attackers having the computing power to guess passwords twice as quickly.
     *
     * bcrypt() is for creating a Hash , which is a one-way process to turn a plain-text string into a hashed value.
     * You cannot un-hash a value, so there is no way to return the value to it's "normal" state. encrypt() is for
     * "obfuscation", which changes the plain-text string into a non-human readable value.
     * @return encrypted password
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Méthodes
    /**
     * Authentification Method
     * @param username String should be login
     * @param password String should be known password
     * @return authentification if correct, otherwise throws AuthenticationException
     * @throws AuthenticationException if password and/or login incorrect
     */
    @Override
    public Authentication authenticate(String username, String password) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authentication);
    }

    // REGISTER A REDIGER
    @Override
    public UserDetails save(String username, String password, String lastname, String surname) throws AccountExistException {
        //Garde de vérif qu'on a pas déjà un login identique
        if (userDao.findByLogin(username) != null){
            throw new AccountExistException();
        }
        User user = new User(); //Constructeur vide
        user.setEmail(username); // Username is Email
        user.setPassword(passwordEncoder().encode(password)); // Ici on garantit le chiffrage du mdp du début à la fin
        user.setLastname(lastname);
        user.setSurname(surname);
        userDao.save(user);
        return user; // user implements Serializable comme UserDetail donc ça marche
    }

    /**
     * This methods set a session token for connected user which last one hour
     * @param user Is an authenticated user
     * @return session token Jwts object
     */
    @Override
    public String generateJWTforUser(UserDetails user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600 * 1000); //1h à partir de maintenant - durée de la session
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, signingKey).compact();
    }

    /**
     * This methods returns a username from a token
     * @param token security token
     * @return String username
     */
    //METHODE PAS OVERRIDE
    private String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    /**
     * This methods returns a User (UserDeatails) from a jwt (session token)
     * @param jwt (session token)
     * @return user (UserDetails)
     */
    @Override
    public UserDetails getUserFromJWT(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }
    /**
     * This method is implemented by the interface UserService implemented by the interface UserDetails.
     * It loads user with the dao (JPA methods) from username.
     * @param username String
     * @return A User
     * @throws UsernameNotFoundException is not found
     */
    @Override //Méthode implémentée de l'interface implémentée par l'interface UserDetails
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("L'utilisateur n'a pas été trouvé.");
        }
        return user;
    }

    //setters
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
