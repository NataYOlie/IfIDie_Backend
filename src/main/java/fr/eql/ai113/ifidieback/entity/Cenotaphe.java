package fr.eql.ai113.ifidieback.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cenotaphe {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int id_cenotaphe;
    public String visual_path;
    public String epitaph;
    public String password;
    public LocalDate deathProof;
    public LocalDate creationDate;
    public LocalDate paymentDate;

    @OneToOne
    public Cenotaphe previousCenotaphe;
    @OneToOne
    public User user;
    @OneToMany
    public List<LovedOnesAccount> lovedOnesAccounts;
    @OneToMany
    public List<File> files;
    @OneToOne
    public SubscribtionLine subscribtionLine;

    /**
     * Default constructor
     */
    public Cenotaphe() {
    }

    //Getters
    public int getId_cenotaphe() {
        return id_cenotaphe;
    }
    public String getVisual_path() {
        return visual_path;
    }
    public String getEpitaph() {
        return epitaph;
    }
    public String getPassword() {
        return password;
    }
    public LocalDate getDeathProof() {
        return deathProof;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public Cenotaphe getPreviousCenotaphe() {
        return previousCenotaphe;
    }
    public User getUser() {
        return user;
    }
    public List<LovedOnesAccount> getLovedOnesAccounts() {
        return lovedOnesAccounts;
    }
    public List<File> getFiles() {
        return files;
    }
    public SubscribtionLine getSubscribtionLine() {
        return subscribtionLine;
    }

    //Setters

}