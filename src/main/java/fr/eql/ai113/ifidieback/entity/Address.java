package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_address;
    public int nb;
    public String streetName;

    @JsonIgnore
    @ManyToOne
    public Countries contry;


    /**
     * Default constructor
     */
    public Address() {
    }

    //Getters
    public int getId_address() {
        return id_address;
    }
    public int getNb() {
        return nb;
    }
    public String getStreetName() {
        return streetName;
    }
    public Countries getContry() {
        return contry;
    }

    //Setters

}