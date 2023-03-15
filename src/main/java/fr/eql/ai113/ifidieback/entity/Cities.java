package fr.eql.ai113.ifidieback.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Citiy of a country
 */
@Entity
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_city;
    public String cityName;
    public String zipcode;

    @ManyToOne
    public Countries country;

    /**
     * Default constructor
     */
    public Cities() {
    }

    //Getters
    public int getId_city() {
        return id_city;
    }
    public String getCityName() {
        return cityName;
    }
    public String getZipcode() {
        return zipcode;
    }
    public Countries getCountry() {
        return country;
    }

    //Setters

}