package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.TaskService;
import fr.eql.ai113.ifidieback.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adminboard")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminBoardController {

    public TaskService taskService;
    public UserService userService;

    @PostMapping("/{toto}")
    public String toto(@PathVariable String toto){

        return toto;
    }

    @GetMapping("/steplist")
    public List<Task> getDefaultStepTasksAdmin (){
        return taskService.getDefaultStepTasks("default", 1);
    }

    @PostMapping("/savetask")
    public Task saveTask(@RequestBody Task task){
        System.out.println(task.getDescription());
        User user = (User) userService.getUserById(1); // A CHANGER C'EST PAS BIEN
        task.setUser(user);
        Task task1 = new Task();
        task1=task;
        System.out.println(task1);
        return taskService.saveTask(task1);
    }


}
