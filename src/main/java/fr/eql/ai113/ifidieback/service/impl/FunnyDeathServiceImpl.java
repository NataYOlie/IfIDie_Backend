package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.Funnydeath;
import fr.eql.ai113.ifidieback.repository.FunnyDeathDao;
import fr.eql.ai113.ifidieback.service.FunnyDeathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FunnyDeathServiceImpl implements FunnyDeathService {

    /**
     * Autowired in accessor
     */
    private FunnyDeathDao funnyDeathDao;

    @Override
    public Funnydeath saveFunnyDeath(Funnydeath funnydeath) {
        return funnyDeathDao.save(funnydeath);
    }
    @Override
    public Funnydeath updateFunnyDeath(Funnydeath funnydeath) {
        return funnyDeathDao.save(funnydeath);
    }
    @Override
    public void deleteFunnyDeathById(Integer id) {
        funnyDeathDao.deleteById(id);
    }

    @Override
    public List<Funnydeath> getFunnyDeaths() {
        return funnyDeathDao.findAll();
    }

    @Override
    public Funnydeath getRandomFunnyDeath() {
        List<Funnydeath> funnydeaths = getFunnyDeaths();
        int random = new Random().nextInt(funnydeaths.size());
        return funnydeaths.get(random);
    }

    @Override
    public Optional<Funnydeath> findFunnyDeathById(Integer id){
        return funnyDeathDao.findById(id);
    }

    //Setter
    @Autowired
    public void setFunnyDeathDao(FunnyDeathDao funnyDeathDao) {
        this.funnyDeathDao = funnyDeathDao;
    }
}
