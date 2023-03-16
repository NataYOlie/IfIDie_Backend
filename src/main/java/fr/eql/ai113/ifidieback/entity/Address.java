package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_address;
    private int nb;
    private String streetName;

    @JsonIgnore
    @ManyToOne
    private Countries country;
    @ManyToOne
    private Cities city;

    @ManyToOne
    User user;




    /**
     * Default constructor
     */
    public Address() {
    }
    public Address(int nb, String streetName, Countries country) {
        this.nb = nb;
        this.streetName = streetName;
        this.country = country;
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
    public Countries getCountry() {
        return country;
    }
    public Cities getCity() {
        return city;
    }
    //Setters
    public void setNb(int nb) {
        this.nb = nb;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public void setCountry(Countries country) {
        this.country = country;
    }
    public void setCity(Cities city) {
        this.city = city;
    }
}