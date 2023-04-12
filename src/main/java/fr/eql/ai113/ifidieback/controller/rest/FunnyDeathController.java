package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Funnydeath;
import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.FunnyDeathService;
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

    @GetMapping()
    private Funnydeath getRandomFunnyDeath (){
        return funnyDeathService.getRandomFunnyDeath();
    }

    //Setter
    @Autowired
    public void setFunnyDeathService(FunnyDeathService funnyDeathService) {
        this.funnyDeathService = funnyDeathService;
    }
}
