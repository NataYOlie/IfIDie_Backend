package fr.eql.ai113.ifidieback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Type of a file (jpg, png, wav, mp4...). This is useful in the converter function.
 */
@Entity
public class FileType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_fileType;
    public String fileTypeName;


    /**
     * Default constructor
     */
    public FileType() {
    }

}