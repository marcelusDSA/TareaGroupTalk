package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Respuestas;
import edu.upc.eetac.dsa.grouptalk.entity.Temas;


import java.sql.SQLException;

/**
 * Created by marcelus on 25/10/15.
 */
public interface RespuestaDAO {

    public Respuestas crear_respuesta(String userid,  String temaid, String respuesta) throws SQLException, UserAlreadyExistsException;
    public Respuestas obtener_respuesta_por_id (String id ) throws SQLException, UserAlreadyExistsException;
}
