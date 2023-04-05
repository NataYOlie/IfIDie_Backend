package fr.eql.ai113.ifidieback.repository;
import fr.eql.ai113.ifidieback.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesDao extends JpaRepository<Roles, Integer> {

//    @Query("SELECT r FROM Roles r where r.roleName = :name")
    Roles findByRoleName(String roleName);
}
