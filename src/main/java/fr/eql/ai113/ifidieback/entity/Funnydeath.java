package fr.eql.ai113.ifidieback.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Funnydeath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_funnydeath;
    public String deadName ;
    public String header;
    @Column(columnDefinition="TEXT")
    public String content;
    public Date deadDate;

    //Getters
    public Integer getId_funnydeath() {
        return id_funnydeath;
    }
    public String getDeadName() {
        return deadName;
    }
    public String getHeader() {
        return header;
    }
    public String getContent() {
        return content;
    }
    public Date getDeadDate() {
        return deadDate;
    }

    //Setters
    public void setId_funnydeath(Integer id_funnydeath) {
        this.id_funnydeath = id_funnydeath;
    }
    public void setDeadName(String deadName) {
        this.deadName = deadName;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setDeadDate(Date deadDate) {
        this.deadDate = deadDate;
    }
}
