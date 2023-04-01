package fr.eql.ai113.ifidieback.entity.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponse {

    private UserDetails owner;
    private String token;

    public AuthResponse(UserDetails owner, String token) {
        this.owner = owner;
        this.token = token;
    }

    /// Getters ///
    public UserDetails getOwner() {
        return owner;
    }
    public String getToken() {
        return token;
    }

}
