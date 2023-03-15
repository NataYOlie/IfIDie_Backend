package fr.eql.ai113.ifidieback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 */
@Entity
public class Roles {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int id_role;
    public String roleName;

    /**
     * Default constructor
     */
    public Roles() {
    }

    //Getters
    public int getId_role() {
        return id_role;
    }
    public String getRoleName() {
        return roleName;
    }

    //Setters
    public void setRoleName(String title) {
        this.roleName = title;
    }
}