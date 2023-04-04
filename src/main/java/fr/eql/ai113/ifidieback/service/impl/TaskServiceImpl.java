package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.repository.TaskDao;
import fr.eql.ai113.ifidieback.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    /**
     * Injecté par le setter
     */
    private TaskDao taskDao ;


    /**
     * This method returns the default List of StepListTasks
     * @param subtype is the subtype (here supposed to be "default")
     * @param id_user connectedUser (here supposed to be someone with ROLE_ADMIN role)
     * @return a list of tasks.
     */
    @Override
    public List<Task> getDefaultStepTasks(String subtype, Integer id_user) {
        List<Task> defaultStepTasks = taskDao.findDefaultStepTasksBySubtype(subtype, id_user);
        return defaultStepTasks;
    }


    @Override
    public UserDetails saveMyStepTasks(UserDetails connectedUser, List<Task> myStepTasks) {
        return null;
    }

    /**
     * This method saves the task in database
     * @param task a new Task
     * @return the saved task
     */
    @Override
    public Task save(Task task) {
        taskDao.save(task);
        return task;
    }

    //Getter
    public TaskDao getTaskDao() {
        return taskDao;
    }

    //Setter
    @Autowired
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
}
