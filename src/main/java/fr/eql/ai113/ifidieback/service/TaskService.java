package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TaskService {

    List<Task> getDefaultStepTasks();
    List<Task> getMyStepTasks(User user);
    UserDetails saveMyStepTasks(UserDetails connectedUser, List<Task> myStepTasks);
    Task updateTask(Task task);
    Task saveTask(Task task, String listType);
}
