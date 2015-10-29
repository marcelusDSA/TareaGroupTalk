package edu.upc.eetac.dsa.grouptalk.auth;

import edu.upc.eetac.dsa.grouptalk.entity.Role;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelus on 24/10/15.
 */
public class UserInfo implements Principal {
    //La interfaz Principal obliga a implementar un método getName()
    // que debe devolver el nombre del Principal que en nuestro caso será el identificador de usuario.

    private String name;
    private List<Role> roles = new ArrayList<>();
    public UserInfo() {
    }

    public UserInfo(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
