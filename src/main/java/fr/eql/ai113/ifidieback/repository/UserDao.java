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

    @Query("SELECT u FROM User u WHERE u.id_user = :userId")
    User findByUserId(@Param("userId") Integer userId);
}
