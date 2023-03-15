package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

/**
 * Country related to an Address
 */
@Entity
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_country;
    public String countryName;

    @JsonIgnore
    @OneToMany
    public List<Cities> cities;

    /**
     * Default constructor
     */
    public Countries() {
    }

    //Getters
    public int getId_country() {
        return id_country;
    }
    public String getCountryName() {
        return countryName;
    }
    public List<Cities> getCities() {
        return cities;
    }

    //Setters


}