package fr.eql.ai113.ifidieback.repository;
import fr.eql.ai113.ifidieback.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TaskDao  extends JpaRepository<Task, Integer> {

    @Query("select t from Task t where t.defaultTask = true and t.listType.list_name = 'StepList'")
    List<Task> findDefaultStepTasksBySubtype();

    @Query("select t from Task t where t.user.id_user = :userId")
    List<Task> findMyStepTasks(@Param("userId") Integer userId);

    @Query("select t from Task t where t.id_task = :taskId")
    Task findById_task(@Param("taskId") Integer taskId);


}
