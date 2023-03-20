package fr.eql.ai113.ifidieback.repository;
import fr.eql.ai113.ifidieback.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountriesDao extends JpaRepository<Countries, Integer> {

    @Query("SELECT c FROM Countries c where c.countryName = :name")
    Optional<Countries> findCountryByName(@Param("name") String country);
}
