package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Line of a subscription, equivalent of a line of an order
 */
@Entity
public class SubscribtionLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_subLine;
    public int quantity;

    @JsonIgnore
    @ManyToOne
    public Subscribtion subscription;

    /**
     * Default constructor
     */
    public SubscribtionLine() {
    }

    //Getter
    public int getId_subLine() {
        return id_subLine;
    }
    public int getQuantity() {
        return quantity;
    }
    public Subscribtion getSubscription() {
        return subscription;
    }
}