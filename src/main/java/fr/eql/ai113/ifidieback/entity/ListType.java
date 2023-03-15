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
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int id_task_type;
    public String list_name;

    @JsonIgnore
    @OneToMany
    public List<Task> tasks;

    /**
     * Default constructor
     */
    public ListType() {
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
}