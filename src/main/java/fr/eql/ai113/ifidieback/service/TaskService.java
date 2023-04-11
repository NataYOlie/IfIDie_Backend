package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getDefaultStepTasks();
    List<Task> getMyStepTasks(Integer userId);
    List<Task> saveMyStepTasks(Integer userId, List<Task> myStepTasks) ;
    Optional<Task> findById(Integer id);
    Task updateTask(Task task);
    Task saveTask(Task task, String listType);
    void deleteTaskById(Integer id);
}
