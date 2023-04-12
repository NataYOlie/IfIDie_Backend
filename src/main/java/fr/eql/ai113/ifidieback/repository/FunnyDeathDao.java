package fr.eql.ai113.ifidieback.repository;

import fr.eql.ai113.ifidieback.entity.Funnydeath;
import fr.eql.ai113.ifidieback.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FunnyDeathDao extends JpaRepository<Funnydeath, Integer> {


}
