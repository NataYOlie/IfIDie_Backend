package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.*;
import fr.eql.ai113.ifidieback.repository.CitiesDao;
import fr.eql.ai113.ifidieback.repository.CountriesDao;
import fr.eql.ai113.ifidieback.repository.RolesDao;
import fr.eql.ai113.ifidieback.repository.UserDao;
import fr.eql.ai113.ifidieback.service.CommunicationService;
import fr.eql.ai113.ifidieback.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoginServiceImpl implements LoginService {

    Logger logger = LogManager.getLogger();

    /** Injected via accessor */
    private UserDao userDao;
    /** Injected via accessor */
    private RolesDao rolesDao;
    /** Injected via accessor */
    private CitiesDao citiesDao;
    /** Injected via accessor */
    private CountriesDao countriesDao;
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
        logger.info("user is created in system : " + user.getSurname() + " " + user.getLastname());


        Countries countryAddress = new Countries();
        countryAddress.setCountryName(country);
        Cities cityAddress = new Cities();

        //Create Address
        try {
            countryAddress = countriesDao.findCountryByName(country).orElse(countryAddress);

        }catch (NullPointerException e){
            logger.info(countriesDao + " - " + userDao + " - " + rolesDao + " - " + citiesDao);
            countriesDao.save(countryAddress);
            logger.info("country " + countryAddress + " is created");
            //A RETIRER UNE FOIS LA DB OK
        }


        try {
            cityAddress = citiesDao.findCityByNameAndCountry(city, countryAddress).orElse(null);
        }catch (NullPointerException e){
            //A RETIRER UNE FOIS LA DB OK
            cityAddress = new Cities(city, "ZIP", countryAddress);
            citiesDao.save(cityAddress);
            logger.info("city " + cityAddress.cityName + " create in country " + countryAddress);
        }




        Address address = new Address(addressNb, addressStreetName,countryAddress);
        address.setCity(cityAddress);
        user.addAddress(address);
        logger.info("user address affected");

        //Set Role as user (as written in database

//A RETIRER UNE FOIS LA DB OK
        Roles roles = new Roles();
        roles.setRoleName("user"); //OK Pour TEST
        rolesDao.save(roles);

        user.setRole(rolesDao.findByName("user").orElse(roles));

        //Set creation date
        user.setCreationDate(LocalDate.now());

        //Send a validation email
        communicationService.sendMail(email);

        return userDao.save(user);
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
    @Autowired
    public void setRolesDao(RolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }
    @Autowired
    public void setCitiesDao(CitiesDao citiesDao) {
        this.citiesDao = citiesDao;
    }
    @Autowired
    public void setCountriesDao(CountriesDao countriesDao) {
        this.countriesDao = countriesDao;
    }
}
