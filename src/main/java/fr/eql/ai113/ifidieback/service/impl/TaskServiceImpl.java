package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.ListType;
import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.repository.ListTypeDao;
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
     * Injecté par le setter
     */
    private ListTypeDao listTypeDao;


    /**
     * This method returns the default List of StepListTasks
     * @return a list of tasks.
     */
    @Override
    public List<Task> getDefaultStepTasks() {
        List<Task> defaultStepTasks = taskDao.findDefaultStepTasksBySubtype();
        return defaultStepTasks;
    }


    @Override
    public UserDetails saveMyStepTasks(UserDetails connectedUser, List<Task> myStepTasks) {
        return null;
    }

    /**
     * This method update the task in database
     * @param taskId a Task
     * @return the updated task
     */
    @Override
    public Task updateTask(Integer taskId) {
        Task task = taskDao.findById_task(taskId);
        taskDao.save(task);
        return task;
    }

    /**
     * This method saves the task in database
     * @param task a new Task
     * @return the saved task
     */
    @Override
    public Task saveTask(Task task, String listType) {
        System.out.println("youyou");
         ListType listTypeSave = listTypeDao.findByList_name(listType);

         task.setListType(listTypeSave);
        return taskDao.save(task);
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
    @Autowired
    public void setListTypeDao(ListTypeDao listTypeDao) {
        this.listTypeDao = listTypeDao;
    }
}
