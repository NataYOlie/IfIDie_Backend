package fr.eql.ai113.ifidieback.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * POJO for the User
 */
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    private String lastname;
    private String surname;

    @JsonIgnore
    @Column(unique = true) //permet de changer le nom de la colonne mais aussi de faire du contrôle
    private String login;
    @JsonIgnore
    private String password;

    private String phone_nb;
    private String email;
    private LocalDate creationDate;
    private LocalDate emailVerificationDate;
    private LocalDate trustedPersonConsentDate;
    private LocalDate closingDate;
    private LocalDate date_of_birth;
    private LocalDate deathDate;
    private String causeOfDeath;

    //Security
    @ManyToMany(fetch = FetchType.EAGER) // on ne peut pas mettre 2 attributs du même objet en Eager. si il y avait une
    // collection dans la collection et que cette collection était en eager aussi ça ferait une boucle infinie
    private Collection<Roles> roles;

    @JsonIgnore
    @OneToMany
    private List<Address> addresses;
    @OneToOne
    private User trustedPerson;

    @JsonIgnore
    @OneToMany
    private List <TimeCapsule> timeCapsules;
    @OneToOne
    private Cenotaphe cenotaphe;
    @JsonIgnore
    @OneToMany
    private List <PostMortemLetter> postMortemLetters;

    @JsonIgnore
    @OneToMany
    List<WebSiteImIn> webSiteImIns ;
    @JsonIgnore
    @OneToMany
    List<WebFindMeResult> webFindMeResults ;
    @JsonIgnore
    @OneToMany
    List<Subscribtion> subscriptions ;
    @JsonIgnore
    @OneToMany
    List<ListType> listTypes;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Task> tasks;


    /**
     * Methods User Details
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @Override
    public String getUsername() {
        return login;
    } //Est-ce que c'est ça ?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Constructor use to register a basic user
     * @param lastname String for lastname
     * @param surname String for surname
     * @param password String for lastname
     * @param phone_nb String phonenb must be "00-00-00-00-00"
     * @param email {toto}@{toto}.{toto}
     * @param date_of_birth LocalDate (YYYY-MM-DD)
     */
    public User(String lastname, String surname, String password, String phone_nb, String email, LocalDate date_of_birth) {
        this.lastname = lastname;
        this.surname = surname;
        this.password = password;
        this.phone_nb = phone_nb;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }
    /**
     * Constructor to build a trusted person
     * @param lastname
     * @param surname
     * @param email
     */
    public User(String lastname, String surname, String email) {
        this.lastname = lastname;
        this.surname = surname;
        this.email = email;
    }
    //Getters
    public String getLogin() {
        return login;
    }
    public Integer getId_user() {
        return id_user;
    }
    public String getLastname() {
        return lastname;
    }
    public String getSurname() {
        return surname;
    }
    public String getPassword() {
        return password;
    }
    public String getPhone_nb() {
        return phone_nb;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getEmailVerificationDate() {
        return emailVerificationDate;
    }
    public LocalDate getTrustedPersonConsentDate() {
        return trustedPersonConsentDate;
    }
    public LocalDate getClosingDate() {
        return closingDate;
    }
    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }
    public LocalDate getDeathDate() {
        return deathDate;
    }
    public String getCauseOfDeath() {
        return causeOfDeath;
    }
    public Collection<Roles> getRoles() {
        return roles;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public User getTrustedPerson() {
        return trustedPerson;
    }
    public List<TimeCapsule> getTimeCapsules() {
        return timeCapsules;
    }
    public Cenotaphe getCenotaphe() {
        return cenotaphe;
    }
    public List<PostMortemLetter> getPostMortemLetters() {
        return postMortemLetters;
    }
    public List<WebSiteImIn> getWebSiteImIns() {
        return webSiteImIns;
    }
    public List<WebFindMeResult> getWebFindMeResults() {
        return webFindMeResults;
    }
    public List<Subscribtion> getSubscriptions() {
        return subscriptions;
    }
    public List<ListType> getListTypes() {
        return listTypes;
    }

    //Setters
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone_nb(String phone_nb) {
        this.phone_nb = phone_nb;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }
    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }
    public void setTrustedPerson(User trustedPerson) {
        this.trustedPerson = trustedPerson;
    }
    public void setTimeCapsules(List<TimeCapsule> timeCapsules) {
        this.timeCapsules = timeCapsules;
    }
    public void setCenotaphe(Cenotaphe cenotaphe) {
        this.cenotaphe = cenotaphe;
    }
    public void setPostMortemLetters(List<PostMortemLetter> postMortemLetters) {
        this.postMortemLetters = postMortemLetters;
    }
    public void setWebSiteImIns(List<WebSiteImIn> webSiteImIns) {
        this.webSiteImIns = webSiteImIns;
    }
    public void setWebFindMeResults(List<WebFindMeResult> webFindMeResults) {this.webFindMeResults = webFindMeResults;}
    public void setSubscriptions(List<Subscribtion> subscriptions) {
        this.subscriptions = subscriptions;
    }
    public void setListTypes(List<ListType> listTypes) {
        this.listTypes = listTypes;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    public void addAddress(Address address){
        addresses.add(address);
    }
}