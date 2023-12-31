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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_task;
    public String subtype;
    public String header;
    @Column(columnDefinition="TEXT")
    public String description;
    public String comment;
    public String externalLink;
    public LocalDate validationDate;
    public LocalDate previsionalDate;
    public LocalDate modificationDate;
    public LocalDate creationDate;
    public String taskColor;
    public boolean visible = true;
    public boolean defaultTask = false;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_user")
    public User user;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    public List<Period> periods;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    public List<File> files;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_task_type")
    ListType listType;

    /**
     * Default constructor
     */
    public Task() {
    }

    public Task(Integer id_task, String subtype, String header, String description, String comment, String externalLink,
                LocalDate validationDate, LocalDate previsionalDate, LocalDate modificationDate, LocalDate creationDate,
                String taskColor, boolean visible, boolean defaultTask) {
        this.id_task = id_task;
        this.subtype = subtype;
        this.header = header;
        this.description = description;
        this.comment = comment;
        this.externalLink = externalLink;
        this.validationDate = validationDate;
        this.previsionalDate = previsionalDate;
        this.modificationDate = modificationDate;
        this.creationDate = creationDate;
        this.taskColor = taskColor;
        this.visible = visible;
        this.defaultTask = defaultTask;
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
    public boolean getIsVisible() {
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
    public User getUser() {
        return user;
    }
    public boolean getIsDefaultTask() {
        return defaultTask;
    }
    public String getComment() {
        return comment;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getModificationDate() {
        return modificationDate;
    }
    public boolean isVisible() {
        return visible;
    }
    public boolean isDefaultTask() {
        return defaultTask;
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
    public void setUser(User user) {
        this.user = user;
    }
    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }
    public void setId_task(Integer id_task) {
        this.id_task = id_task;
    }
    public void setFiles(List<File> files) {
        this.files = files;
    }
    public void setListType(ListType listType) {
        this.listType = listType;
    }
    public void setDefaultTask(boolean defaultTask) {
        this.defaultTask = defaultTask;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }
}