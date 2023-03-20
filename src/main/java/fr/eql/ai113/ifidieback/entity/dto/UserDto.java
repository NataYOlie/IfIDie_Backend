package fr.eql.ai113.ifidieback.entity.dto;

import java.time.LocalDate;

/**
 * User dto
 */
public class UserDto {
    String lastname;
    String surname;
    String password;
    int addressNb;
    String addressStreetName;
    String country;
    String city;
    String phoneNumber;
    String email;
    LocalDate birthDate;

    ///Constructeur
    public UserDto() {
    }

    public UserDto(String lastname, String surname, String password, int addressNb, String addressStreetName,
                   String country, String city, String phoneNumber, String email, LocalDate birthDate) {
        this.lastname = lastname;
        this.surname = surname;
        this.password = password;
        this.addressNb = addressNb;
        this.addressStreetName = addressStreetName;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
    }

    ///Getters
    public String getLastname() {
        return lastname;
    }
    public String getSurname() {
        return surname;
    }
    public String getPassword() {
        return password;
    }
    public int getAddressNb() {
        return addressNb;
    }
    public String getAddressStreetName() {
        return addressStreetName;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
}
