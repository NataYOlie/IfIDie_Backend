package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Funnydeath;
import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.FunnyDeathService;
import fr.eql.ai113.ifidieback.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funnydeath")
@CrossOrigin(origins = "${front.url}")
public class FunnyDeathController {

    Logger logger = LogManager.getLogger();

    /**
     * Injecté par le setter
     */
    FunnyDeathService funnyDeathService;
    /**
     * Injecté par le setter
     */
    UserService userService;

    @GetMapping()
    private Funnydeath getRandomFunnyDeath (){
        logger.info("Random FunnyDeath is in its way !");
        return funnyDeathService.getRandomFunnyDeath();
    }


    //Setter
    @Autowired
    public void setFunnyDeathService(FunnyDeathService funnyDeathService) {
        this.funnyDeathService = funnyDeathService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
