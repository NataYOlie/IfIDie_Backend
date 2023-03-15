package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * This is equivalent to an order
 */
@Entity
public class Subscribtion {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int id_subscription;
    public LocalDate subscriptionDate;
    public LocalDate paymentDate;

    @JsonIgnore
    @OneToMany
    public List<SubscribtionLine> subscribtionLineList;
    @JsonIgnore
    @OneToOne
    public User user;

    /**
     * Default constructor
     */
    public Subscribtion() {
    }

    //Getters

    public int getId_subscription() {
        return id_subscription;
    }
    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public List<SubscribtionLine> getSubscribtionLineList() {
        return subscribtionLineList;
    }
    public User getUser() {
        return user;
    }

    //Setters
    public void setSubscribtionLineList(List<SubscribtionLine> subscribtionLineList) {
        this.subscribtionLineList = subscribtionLineList;
    }
    public void setUser(User user) {
        this.user = user;
    }
}