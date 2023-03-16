package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.User;

import java.time.LocalDate;

public interface LoginService {

    User authenticate(String login, String password);
    User register(String lastname, String surname, String password, int addressNb, String addressStreetName,
                  String country, String city, String phoneNumber, String email, LocalDate birthDate);
    User trustedPersonAffect(User client, String name, String surname, String email);

}
