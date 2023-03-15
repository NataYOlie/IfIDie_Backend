package fr.eql.ai113.ifidieback.entity;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class PostMortemLetter {

    public int id_letter;
    public String title;
    public String content;
    public LocalDate deliveryDate;
    public String path;
    public LocalDate creationDate;
    public String comment;
    public LocalDate paymentDate;
    public String letterTemplate;

    public List<File> files;
    public User user;
    SubscribtionLine subscribtionLine;

    /**
     * Default constructor
     */
    public PostMortemLetter() {
    }

}