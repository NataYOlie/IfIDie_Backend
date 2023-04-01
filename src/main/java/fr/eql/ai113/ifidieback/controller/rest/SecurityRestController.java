package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.dto.AuthRequest;
import fr.eql.ai113.ifidieback.entity.dto.AuthResponse;
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
            UserDetails owner = (UserDetails) authentication.getPrincipal(); //On récupère l'owner.
            // Owner implements UserDetails, on caste l'auth en UserDetails
            String token = userService.generateJWTforUser(owner); // On récupère le token

            return ResponseEntity.ok(new AuthResponse(owner, token)); //On renvoie la réponse validée
        }catch (AuthenticationException e){
            throw new UnauthorizedException();
        }
    }

    ///Methode d'enregistrement
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistException {
        UserDetails owner = userService.save(requestDto.getUsername(), requestDto.getPassword());
        String token = userService.generateJWTforUser(owner);
        return ResponseEntity.ok(new AuthResponse(owner, token)); //On renvoie la réponse validée
    }


    //Setter
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
