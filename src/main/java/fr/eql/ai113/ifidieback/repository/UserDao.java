package fr.eql.ai113.ifidieback.repository;

import fr.eql.ai113.ifidieback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao extends JpaRepository<User, Integer> {

//    User exists();
    User findByLoginAndPassword(String login, String password);
    User findByLogin(String login);

    @Query("select u from User u where u.id_user = :userId")
    UserDetails findByUserId(@Param("userId") Integer userId);
}
