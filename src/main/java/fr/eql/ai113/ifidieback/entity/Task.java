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
    public Integer id_task;
    public String subtype;
    public String header;
    public String description;
    public String externalLink;
    public LocalDate validationDate;
    public LocalDate previsionalDate;
    public String taskColor;
    public boolean visible;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_user")
    public User user;

    @JsonIgnore
    @OneToMany
    public List<Period> periods;
    @JsonIgnore
    @OneToMany
    public List<File> files;
    @JsonIgnore
    @ManyToOne
    ListType listType;

    /**
     * Default constructor
     */
    public Task() {
    }

    //Getters
    public Integer getId_task() {
        return id_task;
    }
    public String getSubtype() {
        return subtype;
    }
    public String getHeader() {
        return header;
    }
    public String getDescription() {
        return description;
    }
    public String getExternalLink() {
        return externalLink;
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
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
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