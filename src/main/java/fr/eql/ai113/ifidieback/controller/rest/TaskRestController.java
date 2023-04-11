package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.TaskService;
import fr.eql.ai113.ifidieback.service.UserService;
import fr.eql.ai113.ifidieback.service.impl.AccountDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin(origins ="${front.url}")
public class TaskRestController {

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

    @PostMapping("/savetask/{listType}/{id}")
    public Task saveTask(@RequestBody Task task, @PathVariable Integer id, @PathVariable String listType) {
        User user = userService.getUserById(id);
        task.setUser(user);
        return taskService.saveTask(task, listType);
    }

    //FROM TODOLIST
    @PutMapping("/updatetask/{userid}/{taskid}")
    public Task updateTask(@RequestBody Task newTask, @PathVariable Integer userid, @PathVariable Integer taskid) {
        System.out.println("update in controller + id task " + newTask.getId_task());
        return taskService.findById(taskid)
                .map(task -> {
                    task.setComment(newTask.getComment());
                    task.setValidationDate(newTask.getValidationDate());
                    task.setHeader(newTask.getHeader());
                    task.setDescription(newTask.getDescription());
                    task.setExternalLink(newTask.getExternalLink());
                    User user = userService.getUserById(userid);
                    task.setUser(user);
                    return taskService.saveTask(task, newTask.getListType().toString());
                })
                .orElseGet(() -> {
                    newTask.setId_task(taskid);
                    return taskService.saveTask(newTask, newTask.getListType().toString());
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
