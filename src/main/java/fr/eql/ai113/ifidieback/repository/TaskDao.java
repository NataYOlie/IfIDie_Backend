package fr.eql.ai113.ifidieback.repository;
import fr.eql.ai113.ifidieback.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TaskDao  extends JpaRepository<Task, Integer> {

    @Query("select t from Task t join ListType lt join User u where t.subtype = :subtype and lt.list_name = 'StepList' and t.user.id_user = :idUser")
    List<Task> findDefaultStepTasksBySubtype(@Param("subtype") String subtype, @Param("idUser")Integer idUser);
}
