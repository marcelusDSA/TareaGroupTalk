package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Respuestas;
import edu.upc.eetac.dsa.grouptalk.entity.Temas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marcelus on 25/10/15.
 */
public class RespuestaDAOImpl implements RespuestaDAO {
    @Override
    public Respuestas crear_respuesta(String userid, String temaid, String respuesta) throws SQLException, UserAlreadyExistsException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String id = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(RespuestaDAOQuery.UUID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                id = rs.getString(1);
            else
                throw new SQLException();

            stmt = connection.prepareStatement(RespuestaDAOQuery.CREAR_RESPUESTA);
            stmt.setString(1, id);
            stmt.setString(2, userid);
            stmt.setString(3, temaid);
            stmt.setString(4, respuesta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return obtener_respuesta_por_id(id);
    }

    @Override
    public Respuestas obtener_respuesta_por_id(String id) throws SQLException, UserAlreadyExistsException {
       Respuestas respuestas = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(RespuestaDAOQuery.OBTENER_RESPUESTA_PORID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                respuestas = new Respuestas();
                respuestas.setUserid(rs.getString("userid"));
                respuestas.setTemaid(rs.getString("temaid"));
                respuestas.setRespuesta(rs.getString("respuesta"));
// "select id,userid,grupoid,titulo,contenido from temas where id=unhex(?);";
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return respuestas;
    }
}
