package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin(origins ="${front.url}")
public class TaskRestController {

    /**
     * Injecté par le setter
     */
    public TaskService taskService;

    @GetMapping("/mySteplist/")
    private List<Task> getMyStepTasks (@RequestBody User user){
        return taskService.getMyStepTasks(user);
    }

    @GetMapping("/steplist")
    public List<Task> getDefaultStepTasks (){
        return taskService.getDefaultStepTasks();
    }

    @PostMapping("/saveTask")
    private Task saveTask(@PathVariable Task task){
        return taskService.updateTask(task);
    }


    //Setter
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
