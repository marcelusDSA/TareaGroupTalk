package edu.upc.eetac.dsa.grouptalk.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.upc.eetac.dsa.grouptalk.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marcelus on 25/10/15.
 */
public class TemaDAOImpl implements TemaDAO {

    @JsonInclude(JsonInclude.Include.NON_NULL)


    @Override
    public Temas creartema(String userid, String grupoid, String titulo, String contenido) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String id = null;

        try {

            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.UUID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
                id = rs.getString(1);
            else
                throw new SQLException();

            stmt = connection.prepareStatement(TemaDAOQuery.CREAR_TEMA);
            stmt.setString(1, id);
            stmt.setString(2, userid);
            stmt.setString(3, grupoid);
            stmt.setString(4, titulo);
            stmt.setString(5, contenido);
            stmt.executeUpdate();


            //  connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return obtenertema_por_temaid(id);
    }


    @Override
    public Temas obtenertema_por_temaid(String id) throws SQLException {

        Temas temas = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.OBTENER_TEMA_PORID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                temas = new Temas();
                temas.setId(rs.getString("id"));
                temas.setUserid(rs.getString("userid"));
                temas.setGrupoid(rs.getString("grupoid"));
                temas.setTitulo(rs.getString("titulo"));
                temas.setContenido(rs.getString("contenido"));
// "select id,userid,grupoid,titulo,contenido from temas where id=unhex(?);";

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return temas;
    }

    @Override
    public ColecciondeTemas obtener_coleccion_temas(String grupoid) {
        ColecciondeTemas colecciondeTemas = new ColecciondeTemas();


        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Database.getConnection();


            stmt = connection.prepareStatement(TemaDAOQuery.OBTENER_TEMAS_POR_GRUPIID);
            stmt.setString(1, grupoid);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Temas temas = new Temas();
                temas.setId(rs.getString("id"));
                temas.setUserid(rs.getString("userid"));
                temas.setTitulo(rs.getString("titulo"));
                temas.setContenido(rs.getString("contenido"));

                colecciondeTemas.getTemas().add(temas);

            }
        } catch (SQLException e) {
        }

        return colecciondeTemas;
    }

    @Override
    public Temas actualizarTema(String id, String contenido) throws SQLException {

        Temas temas = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.ACTUALIZAR_TEMA);
            stmt.setString(1, contenido);
            stmt.setString(2, id);

            int rows = stmt.executeUpdate();
            if (rows == 1)
                temas = obtenertema_por_temaid(id);
        } catch (Exception e) {

        }
        return temas;
    }

    @Override
    public boolean eliminarTemas(String id) throws SQLException {

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.ELIMINAR_TEMA);
            stmt.setString(1, id);

            int rows = stmt.executeUpdate();
            return (rows == 1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }

}





