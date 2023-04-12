package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.Funnydeath;

import java.util.List;
import java.util.Optional;


public interface FunnyDeathService {

    Funnydeath saveFunnyDeath(Funnydeath funnydeath);
    Funnydeath updateFunnyDeath(Funnydeath funnydeath);
    void deleteFunnyDeathById(Integer id);
    List<Funnydeath> getFunnyDeaths();
    Funnydeath getRandomFunnyDeath();

    Optional<Funnydeath> findFunnyDeathById(Integer id);
}
