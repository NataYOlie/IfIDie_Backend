package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.*;
import fr.eql.ai113.ifidieback.entity.dto.UserDto;
import fr.eql.ai113.ifidieback.repository.*;
import fr.eql.ai113.ifidieback.service.CommunicationService;
import fr.eql.ai113.ifidieback.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private AddressDao addressDao;
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
     * @return User
     */
    @Override
    public User register(UserDto userDto) {

        //Create new User
        User user = new User(userDto.getLastname(), userDto.getSurname(), userDto.getPassword(), userDto.getPhoneNumber(),
                userDto.getEmail(), userDto.getBirthDate());
        logger.info("user is created in system : " + user.getSurname() + " " + user.getLastname());

        //Create new Address
        Address address = createAddress(userDto);
        logger.info("We have this address :" + address.getStreetName());
        //Add Address to User Addresses
        List<Address> adresses = new ArrayList<>();
        adresses.add(address);
        user.setAddresses(adresses);

        //Set Role as user (as written in database)
        String roleName = "user";
        user.setRole(getRoleByName(roleName));

        //Set creation date
        user.setCreationDate(LocalDate.now());

        //Send a validation email
        communicationService.sendMail(userDto.getEmail());

        return userDao.save(user);
    }

    /**
     * This internal method is used to register
     * @param roleName can be user or admin
     * @return Roles
     */
    private Roles getRoleByName(String roleName) {
        Roles roles = new Roles();
        try{
            roles = rolesDao.findByName(roleName).orElse(null);

        }catch (Exception e){
            logger.warn("La création du rôle a échoué : ", e);
        }

        //POUR TEST - si le role est null ce qui ne sera pas le cas quand la base de données sera oK
        if(roles == null) {
            roles = new Roles();
            roles.setRoleName(roleName);
            rolesDao.save(roles);
        }
        return roles;
    }

    /**
     * internal method used in registration process (see register)
     * An Address is composed of a Country and a City on top of its own attributes
     * @param userDto UserDto passed by register method
     * @return an Address
     */
    private Address createAddress(UserDto userDto) {
        logger.info("entering create address");

        Countries country = new Countries();
        Cities city = new Cities();
        Address address = new Address();
        address.setNb(userDto.getAddressNb());
        address.setStreetName(userDto.getAddressStreetName());

        //Create new country
        try {
            country = countriesDao.findCountryByName(userDto.getCountry()).orElse(country);
            countriesDao.save(country);
            logger.info("country " + country.countryName + " is created");
            address.setCountry(country);
            if(country.getCountryName() == null) {
                country = new Countries(userDto.getCountry());
                countriesDao.save(country);
                logger.info("IF : country " + country.countryName + " is created");
            }

        }catch (NullPointerException e){
        logger.warn("City could not be created : ", e);
        }

        //Create new city
        try {
            city = citiesDao.findCityByNameAndCountry(userDto.getCity(), country).orElse(city);
            citiesDao.save(city);
            logger.info("city " + city.cityName + " create in country " + country);
            address.setCity(city);

            if(city.getCityName() == null) {
                city = new Cities(userDto.getCity(), "ZIP", country);
                citiesDao.save(city);
                logger.info("IF : city " + city.cityName + " create in country " + country);
            }

        //Create new Address
            addressDao.save(address);
            logger.info(address.getNb() + " " + address.getStreetName() + " is created");

        }catch (Exception e){
            logger.warn("City could not be created : ", e);
        }

        return address;
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
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
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
