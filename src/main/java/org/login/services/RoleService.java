package org.login.services;


import org.login.model.domain.Role;

/**
 * Created by JORGE-HP on 10/6/2017.
 */
public interface RoleService {
    Role findByName(String roleName);
}
