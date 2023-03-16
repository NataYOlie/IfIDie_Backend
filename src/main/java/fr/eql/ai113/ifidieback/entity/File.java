package fr.eql.ai113.ifidieback.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Could be a photo, an audio file, a text or a video
 */
@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_file;
    public String fileName;
    public String path;
    public LocalDate creationDate;
    public LocalDate removalDate;
    public String comment;

    @OneToOne
    public FileType fileType;


    /**
     * Default constructor
     */
    public File() {
    }

    //Getters

    public int getId_file() {
        return id_file;
    }
    public String getFileName() {
        return fileName;
    }
    public String getPath() {
        return path;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getRemovalDate() {
        return removalDate;
    }
    public String getComment() {
        return comment;
    }
    public FileType getFileType() {
        return fileType;
    }

    //Setters


}