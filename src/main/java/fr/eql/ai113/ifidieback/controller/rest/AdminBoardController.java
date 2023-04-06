package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.TaskService;
import fr.eql.ai113.ifidieback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adminboard")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminBoardController {

    public TaskService taskService;
    public UserService userService;


    @GetMapping("/steplist")
    public List<Task> getDefaultStepTasksAdmin (){
        return taskService.getDefaultStepTasks();
    }

    @PostMapping("/savetask/{listType}/{id}")
    public Task saveTask(@RequestBody Task task, @PathVariable Integer id, @PathVariable String listType){
        User user = (User) userService.getUserById(id);
        task.setUser(user);
        return taskService.saveTask(task, listType);
    }

    @PutMapping("/updatetask")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
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
