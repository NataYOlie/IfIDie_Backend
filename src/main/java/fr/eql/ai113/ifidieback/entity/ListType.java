package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

/**
 * This can be a StepProcessesList, an En Vie List or a Life Calendar. Contains tasks.
 */
@Entity
public class ListType {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id_task_type;
    public String list_name;

    @JsonIgnore
    @OneToMany(mappedBy = "listType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Task> tasks;

    /**
     * Default constructor
     */
    public ListType() {
    }

    public ListType(Integer id_task_type, String list_name) {
        this.id_task_type = id_task_type;
        this.list_name = list_name;
    }

    //Getters
    public int getId_task_type() {
        return id_task_type;
    }
    public String getList_name() {
        return list_name;
    }
    public List<Task> getTasks() {
        return tasks;
    }

    //Setters


    public void setId_task_type(Integer id_task_type) {
        this.id_task_type = id_task_type;
    }
    public void setList_name(String list_name) {
        this.list_name = list_name;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}