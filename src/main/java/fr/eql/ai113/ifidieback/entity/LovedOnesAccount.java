package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * This Account contains a list of users allowed to access a certain content, could be a Time Capsule or a Cenotaphe
 */
@Entity
public class LovedOnesAccount {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_lovedOnes;
    public LocalDate creationDate;
    public LocalDate closingDate;
    public String password;

    @JsonIgnore
    @ManyToMany
    List <User> users;

    /**
     * Default constructor
     */
    public LovedOnesAccount() {
    }

    //Getters
    public int getId_lovedOnes() {
        return id_lovedOnes;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getClosingDate() {
        return closingDate;
    }
    public String getPassword() {
        return password;
    }
    public List<User> getUsers() {
        return users;
    }
}