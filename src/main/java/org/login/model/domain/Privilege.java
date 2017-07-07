package org.login.model.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by JORGE-HP on 10/6/2017.
 */
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long privilegeId;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
