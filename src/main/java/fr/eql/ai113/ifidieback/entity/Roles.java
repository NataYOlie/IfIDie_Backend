package fr.eql.ai113.ifidieback.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 */
@Entity
public class Roles implements GrantedAuthority {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id_role;
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
    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }


    /**
     * Methode Granted Authority
     * @return le nom du rôle
     */
    @Override
    public String getAuthority() {
        return roleName;
    }
}