package fr.eql.ai113.ifidieback.entity.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponse {

    private UserDetails user;
    private String token;

    public AuthResponse(UserDetails user, String token) {
        this.user = user;
        this.token = token;
    }

    /// Getters ///
    public UserDetails getUser() {
        return user;
    }
    public String getToken() {
        return token;
    }

}
