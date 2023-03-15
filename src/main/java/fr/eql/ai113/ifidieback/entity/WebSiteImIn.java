package fr.eql.ai113.ifidieback.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * This POJO is an item of a list of websites from which the user wants to apply a certain after-death strategy.
 * It is supposed to be ether a social media, a forum, or any website that identifies the user as a recognizable person.
 */
@Entity
public class WebSiteImIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int idWebSiteImIn;
    public String title;
    public LocalDate creationDate;
    public LocalDate removalDate;
    public String path;
    public String pseudo;

    @ManyToOne
    public User user;
    @OneToOne
    public Strategy strategy;

    /**
     * Default constructor
     */
    public WebSiteImIn() {
    }

    //Getters
    public int getIdWebSiteImIn() {
        return idWebSiteImIn;
    }
    public String getTitle() {
        return title;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getRemovalDate() {
        return removalDate;
    }
    public String getPath() {
        return path;
    }
    public String getPseudo() {
        return pseudo;
    }
    public User getUser() {
        return user;
    }
    public Strategy getStrategy() {
        return strategy;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}