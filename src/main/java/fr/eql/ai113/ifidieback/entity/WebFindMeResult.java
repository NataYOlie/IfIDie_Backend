package fr.eql.ai113.ifidieback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * All Results of a WebFindMeResult
 */
@Entity
public class WebFindMeResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_wfmResult;
    public String url;
    public String keywords;

    @JsonIgnore
    @ManyToOne
    public User user;
    @JsonIgnore
    @ManyToMany
    public List<File> files;

    /**
     * Default constructor
     */
    public WebFindMeResult() {
    }

    //Getters
    public int getId_wfmResult() {
        return id_wfmResult;
    }
    public String getUrl() {
        return url;
    }
    public String getKeywords() {
        return keywords;
    }
    public User getUser() {
        return user;
    }
    public List<File> getFiles() {
        return files;
    }

    //Setters
    public void setUrl(String url) {
        this.url = url;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public void setFiles(List<File> files) {
        this.files = files;
    }
}