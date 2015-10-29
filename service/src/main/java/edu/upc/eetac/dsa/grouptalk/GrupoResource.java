package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.GrupoDAO;
import edu.upc.eetac.dsa.grouptalk.dao.GrupoDAOImpl;
import edu.upc.eetac.dsa.grouptalk.dao.TemaDAO;
import edu.upc.eetac.dsa.grouptalk.dao.TemaDAOImpl;
import edu.upc.eetac.dsa.grouptalk.entity.*;

import javax.ws.rs.*;
import java.sql.SQLException;

/**
 * Created by marcelus on 25/10/15.
 */
@Path("grupos")
public class GrupoResource {

    @GET
    @Produces(GrouptalkMediaType.BEETER_GRUPO)
    public Colecciondegrupos getcolecciondegrupos() throws SQLException {

        Colecciondegrupos colecciondegrupos = null;
        GrupoDAO grupoDAO = new GrupoDAOImpl();


            colecciondegrupos = grupoDAO.obtenercolecciondegrupos();

        return colecciondegrupos;

    }
    @Path("/{id}")
    @GET
    @Produces(GrouptalkMediaType.BEETER_TEMAS_COLECCION)
    public ColecciondeTemas obtener_coleccion_Temas(@PathParam("id") String id) {
        // Create cache-control
        ColecciondeTemas colecciondeTemas = null;

        TemaDAO temaDAO = new TemaDAOImpl();

                colecciondeTemas = temaDAO.obtener_coleccion_temas(id);

        return colecciondeTemas;
    }
}
