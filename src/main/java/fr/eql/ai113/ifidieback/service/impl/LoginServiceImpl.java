package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.Address;
import fr.eql.ai113.ifidieback.entity.Cities;
import fr.eql.ai113.ifidieback.entity.Countries;
import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.repository.UserDao;
import fr.eql.ai113.ifidieback.service.CommunicationService;
import fr.eql.ai113.ifidieback.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoginServiceImpl implements LoginService {

    /** Injected via accessor */
    private UserDao userDao;
    /** Injected via accessor */
    private CommunicationService communicationService;

    //Methods
    /**
     *This method is use for authentification of a known User
     * @param login String
     * @param password String
     * @return User
     */
    @Override
    public User authenticate(String login, String password) {
        return userDao.findByLoginAndPassword(login, password);
    }

    /**
     * This method is used to register, it creates a User and its address.
     * @param lastname String
     * @param surname String
     * @param password String
     * @param addressNb int
     * @param addressStreetName String
     * @param country String (checked)
     * @param city String (checked)
     * @param phoneNumber String
     * @param email String (checked)
     * @param birthDate LocalDate
     * @return User
     */
    @Override
    public User register(String lastname, String surname, String password, int addressNb, String addressStreetName,
                         String country, String city, String phoneNumber, String email, LocalDate birthDate) {

        //Create new User
        User user = new User(lastname,surname,password,phoneNumber, email,birthDate);

        //Create Address
        Countries countryAddress = userDao.findCountryByName(country);
        Cities cityAddress = userDao.findCityByNameAndCountry(city, countryAddress);
        Address address = new Address(addressNb, addressStreetName,countryAddress);
        address.setCity(cityAddress);
        user.addAddress(address);

        //Set Role as user (as written in database
        user.setRole(userDao.findByName("user"));

        //Set creation date
        user.setCreationDate(LocalDate.now());

        //Send a validation email
        communicationService.sendMail(email);

        return user;
    }

    /**
     *
     * @param client is a User to which the Trusted Person is related by this app
     * @param name String > name of the Trusted Person
     * @param surname String > surname of the Trusted Person
     * @param email String > email of the Trusted Person / should be check in front
     * @return The trusted person, also a User
     */
    @Override
    public User trustedPersonAffect(User client, String name, String surname, String email) {
        User trustedPerson = new User(name, surname, email);
        client.setTrustedPerson(trustedPerson);

        return trustedPerson;
    }


    //Setters
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setCommunicationService(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }
}
