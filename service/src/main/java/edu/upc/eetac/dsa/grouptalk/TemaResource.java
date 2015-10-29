package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.TemaDAO;
import edu.upc.eetac.dsa.grouptalk.dao.TemaDAOImpl;
import edu.upc.eetac.dsa.grouptalk.dao.UserDAO;
import edu.upc.eetac.dsa.grouptalk.dao.UserDAOImpl;
import edu.upc.eetac.dsa.grouptalk.entity.AuthToken;
import edu.upc.eetac.dsa.grouptalk.entity.GrouptalkError;
import edu.upc.eetac.dsa.grouptalk.entity.Temas;
import edu.upc.eetac.dsa.grouptalk.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import javax.ws.rs.core.UriInfo;

/**
 * Created by marcelus on 25/10/15.
 */

@Path("tema")
public class TemaResource {

    @Context
    private SecurityContext securityContext;

    @POST
    public Response crerTema(@FormParam("userid") String userid,@FormParam("grupoid") String grupoid, @FormParam("titulo") String titulo, @FormParam("contenido") String contenido, @Context UriInfo uriInfo) throws URISyntaxException {
        if(titulo==null || contenido == null)
            throw new BadRequestException("all parameters are mandatory");

        TemaDAO temaDAO = new TemaDAOImpl();
        Temas temas = null;

        AuthToken authenticationToken = null;
        try {
           // String name = securityContext.getUserPrincipal().getName();
            //String name = "marcelus";
            temas=temaDAO.creartema(userid,grupoid,titulo,contenido);
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }

        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + temas.getId());
        return Response.created(uri).type(GrouptalkMediaType.BEETER_TEMA).entity(temas).build();
    }

    @Path("/{id}")
    @GET
    @Produces(GrouptalkMediaType.BEETER_TEMA)
    public Temas getTema(@PathParam("id") String id) {
        // Create cache-control
        Temas temas = null;

        try {
            temas = (new TemaDAOImpl().obtenertema_por_temaid(id));
        } catch (SQLException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        if (temas == null) {
            throw new NotFoundException("tema with id = " + id + " doesn't exist");
        }
    return temas;

    }
    @Path("/{id}")
    @PUT
    @Consumes(GrouptalkMediaType.BEETER_TEMA)
    @Produces(GrouptalkMediaType.BEETER_TEMA)
    public Temas actializarTema(@PathParam("id") String id, Temas temas) {

        TemaDAO temaDAO = new TemaDAOImpl();

        try {
            temas = temaDAO.actualizarTema(id,temas.getContenido());
            if(temas== null)
                throw new NotFoundException("User with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return temas;
    }
    @Path("/{id}")
    @DELETE
    public void deleteUser(@PathParam("id") String id){
        TemaDAO temaDAO = new TemaDAOImpl();

        try {
            if (!temaDAO.eliminarTemas(id));
                throw new NotFoundException("User with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
    }
}
