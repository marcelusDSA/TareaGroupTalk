package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.auth.UserInfo;
import edu.upc.eetac.dsa.grouptalk.entity.AuthToken;

import java.sql.SQLException;

/**
 * Created by marcelus on 24/10/15.
 */
public interface AuthTokenDAO  {
    //métodos que nos permiten obtener el usuario que tiene asignado el token, crear el token para un usuario
    // y, por último, eliminar el token asociado a un usuario:

    public UserInfo getUserByAuthToken(String token) throws SQLException;
    public AuthToken createAuthToken(String userid) throws SQLException;
    public void deleteToken(String userid) throws SQLException;
}
