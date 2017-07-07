package org.login.services;


import org.login.model.domain.User;
import org.login.model.transfer.UserDTO;

/**
 * Created by JORGE-HP on 10/6/2017.
 */
public interface UserService {
    User findByEmail(String email);
    void create(UserDTO personDTO);
    void create(User user);
    User findByUsername(String username);
}
