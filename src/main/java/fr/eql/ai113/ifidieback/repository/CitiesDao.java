package fr.eql.ai113.ifidieback.repository;

import fr.eql.ai113.ifidieback.entity.Cities;
import fr.eql.ai113.ifidieback.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CitiesDao extends JpaRepository<Cities, Integer> {

    @Query("SELECT c FROM Cities c where c.cityName = :name AND  c.country = :country")
    Optional<Cities> findCityByNameAndCountry(@Param("name") String name, @Param("country") Countries country);
}
