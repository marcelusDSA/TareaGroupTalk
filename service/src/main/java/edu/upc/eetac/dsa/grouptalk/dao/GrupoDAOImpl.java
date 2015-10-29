package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.*;

import java.sql.*;

/**
 * Created by marcelus on 25/10/15.
 */
public class GrupoDAOImpl implements GrupoDAO {

    @Override
    public Colecciondegrupos obtenercolecciondegrupos() {
        Colecciondegrupos colecciondegrupos = new Colecciondegrupos();

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Database.getConnection();


            stmt = connection.prepareStatement(GrupoDAOQuery.GET_GRUPOS);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Grupos grupos = new Grupos();
                grupos.setId(rs.getString("id"));
                grupos.setTipodegrupo(rs.getString("tipodegrupo"));

                colecciondegrupos.getGrupos().add(grupos);
            }
        } catch (SQLException e){}

        return colecciondegrupos;
    }

}

