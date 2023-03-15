package fr.eql.ai113.ifidieback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.*;

/**
 * A Period can be linked to a Task, it can appear in a Life Calendar
 */
@Entity
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_period;
    public String period_color;
    public String periodName;
    public String comment;
    public LocalDate startDate;
    public LocalDate endDate;
    public boolean visible;

    /**
     * Default constructor
     */
    public Period() {
    }

    //Getter
    public int getId_period() {
        return id_period;
    }
    public String getPeriod_color() {
        return period_color;
    }
    public String getPeriodName() {
        return periodName;
    }
    public String getComment() {
        return comment;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public boolean isVisible() {
        return visible;
    }

    //Setters

    public void setPeriod_color(String period_color) {
        this.period_color = period_color;
    }
    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}