package fr.eql.ai113.ifidieback.entity.dto;

import java.time.LocalDate;

public class AuthRequest {

    private String username; // Is email
    private String password;
    String lastname;
    String surname;
    int addressNb;
    String addressStreetName;
    String country;
    String city;
    String phoneNumber;
    LocalDate birthDate;

    /// Getters ///
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getLastname() {
        return lastname;
    }
    public String getSurname() {
        return surname;
    }

    /// Setters ///
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
