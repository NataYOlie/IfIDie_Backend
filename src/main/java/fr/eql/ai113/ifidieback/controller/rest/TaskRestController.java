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
        User user = (User) userService.getUserById(id);
        task.setUser(user);
        return taskService.saveTask(task, listType);
    }

//    @PostMapping("/saveMyList/{listType}/{userId}")
//    private void saveMyTasksList (@RequestBody List<Task> myTasks, @PathVariable Integer userId, @PathVariable String listType)
//            throws AccountDoesNotExistException {
//        List<Task> myDeserializedTasks = new ArrayList<>();
//
//        for (Task task : myTasks
//             ) {
//            saveTask(task,);
//            myDeserializedTasks.add(task);
//            System.out.println("saveMyTaskList : " + task.header + " added to list" );
//        }
//        userService.addTasksToUser(userId, myDeserializedTasks);
//    }


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
