package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
@Entity
public class PostMortemLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_letter;
    public String title;
    public String content;
    public LocalDate deliveryDate;
    public String path;
    public LocalDate creationDate;
    public String comment;
    public LocalDate paymentDate;
    public String letterTemplate;

    @JsonIgnore
    @OneToMany
    public List<File> files;
    @OneToOne
    public User user;
    @OneToOne
    SubscribtionLine subscribtionLine;

    /**
     * Default constructor
     */
    public PostMortemLetter() {
    }

}