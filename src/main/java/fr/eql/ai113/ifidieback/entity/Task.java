package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * A Task is an item of a list or a Life Calendar
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_task;
    public String wording;
    public String comment;
    public LocalDate validationDate;
    public LocalDate previsionalDate;
    public String taskColor;
    public boolean visible;

    @JsonIgnore
    @OneToMany
    public List<Period> periods;
    @JsonIgnore
    @OneToMany
    public List<File> files;
    @JsonIgnore
    @ManyToMany
    ListType listType;

    /**
     * Default constructor
     */
    public Task() {
    }

    //Getters
    public int getId_task() {
        return id_task;
    }
    public String getWording() {
        return wording;
    }
    public String getComment() {
        return comment;
    }
    public LocalDate getValidationDate() {
        return validationDate;
    }
    public LocalDate getPrevisionalDate() {
        return previsionalDate;
    }
    public String getTaskColor() {
        return taskColor;
    }
    public boolean isVisible() {
        return visible;
    }
    public List<Period> getPeriods() {
        return periods;
    }
    public List<File> getFiles() {
        return files;
    }
    public ListType getListType() {
        return listType;
    }

    //Setters
    public void setWording(String wording) {
        this.wording = wording;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }
    public void setPrevisionalDate(LocalDate previsionalDate) {
        this.previsionalDate = previsionalDate;
    }
    public void setTaskColor(String taskColor) {
        this.taskColor = taskColor;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}