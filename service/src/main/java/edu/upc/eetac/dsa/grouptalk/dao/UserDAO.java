package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.User;

import java.sql.SQLException;

/**
 * Created by marcelus on 24/10/15.
 */
public interface UserDAO {

    // En esta interfaz de USERDAO lo que hacemos es crear los metodos con los atributos de la clase USER para poder hacer las
    // las las querys pertinentes ala base de datos.
        public User createUser(String loginid, String password, String email, String fullname) throws SQLException, UserAlreadyExistsException;

        //public User updateProfile(String id, String email, String fullname) throws SQLException;

        public User getUserById(String id) throws SQLException;

        public User getUserByLoginid(String loginid) throws SQLException;

        public boolean deleteUser(String id) throws SQLException;

        public boolean checkPassword(String id, String password) throws SQLException;

}
