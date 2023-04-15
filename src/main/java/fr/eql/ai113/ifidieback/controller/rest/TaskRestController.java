package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.TaskService;
import fr.eql.ai113.ifidieback.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin(origins ="${front.url}")
public class TaskRestController {
    Logger logger = LogManager.getLogger();

    /**
     * Injecté par le setter
     */
    public TaskService taskService;
    /**
     * Injecté par le setter
     */
    public UserService userService;


    @GetMapping("/mySteplist/{userId}")
    private List<Task> getMyStepTasks (@PathVariable("userId") Integer userId){
        return taskService.getMyStepTasks(userId);
    }

    @GetMapping("/steplist")
    public List<Task> getDefaultStepTasks (){
        return taskService.getDefaultStepTasks();
    }

    @PostMapping("/savetask/{listType}/{user_id}")
    public Task saveTask(@RequestBody Task task, @PathVariable Integer user_id, @PathVariable String listType) {
        User user = userService.getUserById(user_id);
        task.setUser(user);
        System.out.println("saved in controller + id task " + task.getId_task() + " and user is : " + user.getSurname());
        return taskService.saveTask(task, listType);
    }

    /**
     * This method update StepList Task
     * @param newTask from Request Body
     * @param userid necessarly an id is asked to update a task, if user not found by ID then new task is created
     * @param taskid if
     * @return
     */
    @PutMapping("/updatetask/{userid}/{taskid}")
    public Task updateTask(@RequestBody Task newTask, @PathVariable Integer userid, @PathVariable Integer taskid) {
        User user = userService.getUserById(userid);
        logger.info("UPDATE IN CONTROLLER user is : " + user.getSurname());
        System.out.println("update in controller + id task " + newTask.getId_task());
        return taskService.findById(taskid)
                .map(task -> {
                    task.setSubtype(newTask.getSubtype());
                    task.setHeader(newTask.getHeader());
                    task.setDescription(newTask.getDescription());
                    task.setExternalLink(newTask.getExternalLink());
                    task.setTaskColor(newTask.getTaskColor());
                    task.setDefaultTask(newTask.getIsDefaultTask());
                    task.setComment(newTask.getComment());
                    task.setValidationDate(newTask.getValidationDate());
                    task.setPrevisionalDate(newTask.getPrevisionalDate());
                    task.setModificationDate(newTask.getModificationDate());
                    task.setUser(user); // SET USER BY PREVIOUSLY FINDING IT WITH ID
                    System.out.println("user is : " + user.getSurname());
                    return taskService.saveTask(task, "StepList"); //Set ListType with this arg
                })
                .orElseGet(() -> {
                    newTask.setId_task(taskid);
                    newTask.setUser(user);
                    return taskService.saveTask(newTask, "StepList");
                });
    }


    //FROM TODOLIST
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }


    //Setter
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
