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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_country;
    public String countryName;

    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Cities> cities;

    /**
     * Default constructor
     */
    public Countries() {
    }
    public Countries(String countryName) {
        this.countryName = countryName;
    }
    //Getters
    public Integer getId_country() {
        return id_country;
    }
    public String getCountryName() {
        return countryName;
    }
    public List<Cities> getCities() {
        return cities;
    }

    //Setters


    public void setId_country(Integer id_country) {
        this.id_country = id_country;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}