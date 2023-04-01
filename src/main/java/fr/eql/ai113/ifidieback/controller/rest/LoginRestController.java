package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.entity.dto.UserDto;
import fr.eql.ai113.ifidieback.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginRestController {

    /**injecté via le setter */
    LoginService loginService;
//
//    @PostMapping("/register")
//    public User register (@RequestBody UserDto userDto){return loginService.register(userDto);}

//    @GetMapping("/{login}/{password}")
//    public User authenticate (@PathVariable String login, @PathVariable String password){
//        return loginService.authenticate(login, password);
//    }

    ///Setters
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
