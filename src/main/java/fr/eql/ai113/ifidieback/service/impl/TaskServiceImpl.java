package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.ListType;
import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.repository.ListTypeDao;
import fr.eql.ai113.ifidieback.repository.TaskDao;
import fr.eql.ai113.ifidieback.repository.UserDao;
import fr.eql.ai113.ifidieback.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * Injecté par le setter
     */
    private UserDao userDao;


    /**
     * This method returns the default List of StepListTasks
     * @return a list of tasks.
     */
    @Override
    public List<Task> getDefaultStepTasks() {
        List<Task> defaultStepTasks = taskDao.findDefaultStepTasksBySubtype();
        return defaultStepTasks;
    }


    /**
     * This methods get UserStepTasks
     * @param userId
     * @return
     */
    @Override
    public List<Task> getMyStepTasks(Integer userId) {
        List<Task> myStepTasks = taskDao.findMyStepTasks(userId);
        System.out.println("myStepTask fait " + myStepTasks.toArray().length);
        return myStepTasks;
    }


    //A ECRIRE
    @Override
    public List<Task> saveMyStepTasks(Integer userId, List<Task> myStepTasks) {
        List<Task> myStepTasks2 = new ArrayList<>();

        return myStepTasks2 ;
    }


    /**
     * This method update the task in database
     * @param task a Task
     * @return the updated task
     */
    @Override
    public Task updateTask(Task task) {
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
        System.out.println("savetask in taskserviceImpl");
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
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
