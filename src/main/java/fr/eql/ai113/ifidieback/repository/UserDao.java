package fr.eql.ai113.ifidieback.repository;

import fr.eql.ai113.ifidieback.entity.Cities;
import fr.eql.ai113.ifidieback.entity.Countries;
import fr.eql.ai113.ifidieback.entity.Roles;
import fr.eql.ai113.ifidieback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User exists();
    User findByLoginAndPassword(String login, String password);
    Countries findCountryByName(String country);
    Cities findCityByNameAndCountry(String name, Countries country);
    Roles findByName(String roleName);
}
