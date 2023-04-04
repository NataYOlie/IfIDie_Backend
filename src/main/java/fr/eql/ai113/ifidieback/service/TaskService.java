package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.Task;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TaskService {

    List<Task> getDefaultStepTasks(String subtype, Integer id_user);
    UserDetails saveMyStepTasks(UserDetails connectedUser, List<Task> myStepTasks);
    Task save(Task task);
}
