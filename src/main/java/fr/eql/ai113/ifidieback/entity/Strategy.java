package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Strategy is linked to a WebSiteImIn, it is supposed to give instructions about what to do with the WebSite when the
 * user pass away.
 */
@Entity
public class Strategy {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int id_strategy;
    public String wording;
    public LocalDate creationDate;
    public LocalDate activationDate;
    public LocalDate removalDate;
    public String mailContent;

    @OneToOne
    private WebSiteImIn webSiteImIn;

    /**
     * Default constructor
     */
    public Strategy() {
    }

    //Getters
    public int getId_strategy() {
        return id_strategy;
    }
    public String getWording() {
        return wording;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getActivationDate() {
        return activationDate;
    }
    public LocalDate getRemovalDate() {
        return removalDate;
    }
    public String getMailContent() {
        return mailContent;
    }

    //Setter
}