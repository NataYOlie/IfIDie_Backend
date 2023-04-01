package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.entity.dto.AuthRequest;
import fr.eql.ai113.ifidieback.entity.dto.AuthResponse;
import fr.eql.ai113.ifidieback.entity.dto.UserDto;
import fr.eql.ai113.ifidieback.service.UserService;
import fr.eql.ai113.ifidieback.service.impl.AccountExistException;
import fr.eql.ai113.ifidieback.service.impl.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityRestController {

    /** injecté par le setter */
    UserService userService ;


    ///Methode d'autentification
    @PostMapping("/authorize")
    public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest requestDto) throws UnauthorizedException {
        Authentication authentication;
        try{
            authentication = userService.authenticate(requestDto.getUsername(), requestDto.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication); //Donne l'authentification au contexte sécurité
            UserDetails user = (UserDetails) authentication.getPrincipal(); //On récupère le user
            // User implements UserDetails, on caste l'auth en UserDetails
            String token = userService.generateJWTforUser(user); // On récupère le token

            return ResponseEntity.ok(new AuthResponse(user, token)); //On renvoie la réponse validée
        }catch (AuthenticationException e){
            throw new UnauthorizedException();
        }
    }

    ///Methode d'enregistrement
    /**
     * This method calls the "save" method in UserService to save user in database and generate a session token
     * @param requestDto
     * @return a response to validate operation
     * @throws AccountExistException if account already exists
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistException {
        UserDetails user = userService.save(requestDto.getUsername(), requestDto.getPassword(),
                                            requestDto.getLastname(), requestDto.getSurname());
        String token = userService.generateJWTforUser(user);
        return ResponseEntity.ok(new AuthResponse(user, token)); //On renvoie la réponse validée
    }

    @PostMapping("/register/full")
    public ResponseEntity<AuthResponse> registerFull(@RequestBody AuthRequest requestDto) throws AccountExistException {
        UserDetails user = userService.saveFull(requestDto.getUsername(), requestDto.getPassword(),
                requestDto.getLastname(), requestDto.getSurname(), requestDto.getAddressNb(), requestDto.getAddressStreetName(),
                requestDto.getCountry(), requestDto.getCity(), requestDto.getPhoneNumber(), requestDto.getBirthDate());
        String token = userService.generateJWTforUser(user);
        return ResponseEntity.ok(new AuthResponse(user, token)); //On renvoie la réponse validée
    }


    //Setter
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
