package fr.eql.ai113.ifidieback.controller.rest;

import fr.eql.ai113.ifidieback.entity.Funnydeath;
import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.service.FunnyDeathService;
import fr.eql.ai113.ifidieback.service.TaskService;
import fr.eql.ai113.ifidieback.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adminboard")
@CrossOrigin(origins = "${front.url}")
public class AdminBoardController {
    Logger logger = LogManager.getLogger();

    /**
     * Injecté par le setter
     */
    public TaskService taskService;
    /**
     * Injecté par le setter
     */
    public UserService userService;
    /**
     * Injecté par le setter
     */
    public FunnyDeathService funnyDeathService;


    @GetMapping("/steplist")
    public List<Task> getDefaultStepTasksAdmin (){
        return taskService.getDefaultStepTasks();
    }

    @PostMapping("/savetask/{listType}/{id}")
    public Task saveTask(@RequestBody Task task, @PathVariable Integer id, @PathVariable String listType){
        User user = (User) userService.getUserById(id);
        task.setUser(user);
        logger.info("task created ! " + task.header);
        return taskService.saveTask(task, listType);
    }

    @PutMapping("/updatetask/{user_id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Integer user_id){
        logger.info("task updates ! " + task.header);
        User user = userService.getUserById(user_id);
        logger.info("UPDATE IN ADMIN CONTROLLER user is : " + user.getSurname());
        System.out.println("update in ADMIN controller + id task " + task.getId_task());
        return taskService.findById(task.id_task)
                .map(taskfound -> {
                    taskfound.setSubtype(task.getSubtype());
                    taskfound.setHeader(task.getHeader());
                    taskfound.setDescription(task.getDescription());
                    taskfound.setExternalLink(task.getExternalLink());
                    taskfound.setTaskColor(task.getTaskColor());
                    taskfound.setDefaultTask(task.getIsDefaultTask());
                    taskfound.setComment(task.getComment());
                    taskfound.setValidationDate(task.getValidationDate());
                    taskfound.setPrevisionalDate(task.getPrevisionalDate());
                    taskfound.setModificationDate(task.getModificationDate());
                    taskfound.setUser(user); // SET USER BY PREVIOUSLY FINDING IT WITH ID
                    System.out.println("user is : " + user.getSurname());
                    return taskService.saveTask(taskfound, "StepList"); //Set ListType with this arg
                })
                .orElseGet(() -> {
                    task.setId_task(task.id_task);
                    task.setUser(user);
                    return taskService.saveTask(task, "StepList");
                });
    }



    @PutMapping("/funnydeath/update/{id_funnydeath}")
    public Funnydeath updateFunnyDeath(@RequestBody Funnydeath newFunnydeath, @PathVariable Integer id_funnydeath) {
        return funnyDeathService.findFunnyDeathById(id_funnydeath)
                .map(funnydeath -> {
                    funnydeath.setContent(newFunnydeath.getContent());
                    funnydeath.setHeader(newFunnydeath.getHeader());
                    funnydeath.setDeadName(newFunnydeath.getDeadName());
                    funnydeath.setDeadDate(newFunnydeath.getDeadDate());
                    logger.info("funnydeath updated for the fun of your beloved users ! " + funnydeath.header);
                    return funnyDeathService.saveFunnyDeath(newFunnydeath);
                }).orElseGet(()-> {
                    newFunnydeath.setId_funnydeath(id_funnydeath);
                    logger.info("new funnydeath created for the fun of your beloved users ! " + newFunnydeath.header);
                    return funnyDeathService.saveFunnyDeath(newFunnydeath);
                });
    }

    @PostMapping("/funnydeath/save")
    public Funnydeath saveFunnydeath(@RequestBody Funnydeath newFunnydeath) {
        logger.info("new funnydeath created for the fun of your beloved users ! " + newFunnydeath.header);
        return funnyDeathService.saveFunnyDeath(newFunnydeath);

    }

    @DeleteMapping("/funnydeath/delete/{fd_id}")
    public void deleteFunnyDeath(@PathVariable Integer fd_id) {
        logger.info("funnydeath deleted, this one was no fun");
        funnyDeathService.deleteFunnyDeathById(fd_id);
    }

    @GetMapping("/funnyDeaths")
    public List<Funnydeath> getFunnyDeaths (){
        return funnyDeathService.getFunnyDeaths();
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
    @Autowired
    public void setFunnyDeathService(FunnyDeathService funnyDeathService) {
        this.funnyDeathService = funnyDeathService;
    }
}
