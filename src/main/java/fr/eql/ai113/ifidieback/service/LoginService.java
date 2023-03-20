package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.entity.dto.UserDto;


public interface LoginService {

    User authenticate(String login, String password);
    User register(UserDto userDto);
    User trustedPersonAffect(User client, String name, String surname, String email);

}
