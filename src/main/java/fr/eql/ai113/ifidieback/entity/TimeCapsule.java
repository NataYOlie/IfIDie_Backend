package fr.eql.ai113.ifidieback.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * TimeCapsule contains the essence of an important moment in a lifetime that is captured and will be transmitted to
 * a list of users
 */
@Entity
public class TimeCapsule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_timeCaps;
    public String title;
    public LocalDate deliveryDate;
    public LocalDate creationDate;
    public String encryptionKey;
    public LocalDate paymentDate;

    @OneToOne
    public TimeCapsule previousVersionTimeCapsule;
    @ManyToOne
    public User user;
    @ManyToMany
    public List<File> files;
    @OneToOne
    public SubscribtionLine subscribtionLine;

    /**
     * Default constructor
     */
    public TimeCapsule() {
    }

    //Getters
    public int getId_timeCaps() {
        return id_timeCaps;
    }
    public String getTitle() {
        return title;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public String getEncryptionKey() {
        return encryptionKey;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public TimeCapsule getPreviousVersionTimeCapsule() {
        return previousVersionTimeCapsule;
    }
    public User getUser() {
        return user;
    }
    public List<File> getFiles() {
        return files;
    }
    public SubscribtionLine getSubscribtionLine() {
        return subscribtionLine;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public void setFiles(List<File> files) {
        this.files = files;
    }
    public void setSubscribtionLine(SubscribtionLine subscribtionLine) {
        this.subscribtionLine = subscribtionLine;
    }
}