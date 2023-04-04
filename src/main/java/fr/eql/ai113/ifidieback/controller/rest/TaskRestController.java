package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Task;
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

    @GetMapping("/steplist/{id}/{subtype}")
    private List<Task> getDefaultStepTasks (@PathVariable Integer id, @PathVariable String subtype){
        return taskService.getDefaultStepTasks(subtype, id);
    }

    @PutMapping("/{id}/save")
    private Task saveTask(@PathVariable Integer taskId){
        return taskService.updateTask(taskId);
    }


    //Setter
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
