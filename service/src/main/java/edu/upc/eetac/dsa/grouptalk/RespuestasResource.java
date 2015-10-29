package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.RespuestaDAO;
import edu.upc.eetac.dsa.grouptalk.dao.RespuestaDAOImpl;
import edu.upc.eetac.dsa.grouptalk.dao.TemaDAO;
import edu.upc.eetac.dsa.grouptalk.dao.TemaDAOImpl;
import edu.upc.eetac.dsa.grouptalk.entity.AuthToken;
import edu.upc.eetac.dsa.grouptalk.entity.Respuestas;
import edu.upc.eetac.dsa.grouptalk.entity.Temas;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by marcelus on 27/10/15.
 */
@Path("respuesta")
public class RespuestasResource {

        @Context
        private SecurityContext securityContext;

        @POST
        public Response crerTema(@FormParam("userid") String userid, @FormParam("temaid") String temaid, @FormParam("respuesta") String respuesta, @Context UriInfo uriInfo) throws URISyntaxException {
            if(userid==null || temaid==null || respuesta == null)
                throw new BadRequestException("all parameters are mandatory");


            RespuestaDAO respuestaDAO = new RespuestaDAOImpl();
            Respuestas respuestas= null;

            AuthToken authenticationToken = null;
            try {
                // String name = securityContext.getUserPrincipal().getName();
                //String name = "marcelus";
                respuestas=respuestaDAO.crear_respuesta(userid, temaid, respuesta);
            } catch (Exception e) {
                throw new InternalServerErrorException();
            }


            URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + respuestas.getId());
            return Response.created(uri).type(GrouptalkMediaType.BEETER_RESPUESTA).entity(respuestas).build();
        }

        @Path("/{id}")
        @GET
        @Produces(GrouptalkMediaType.BEETER_RESPUESTA)
        public Respuestas getRespuestaById(@PathParam("id") String id) {
            // Create cache-control
            Respuestas respuestas = null;

            try {
                respuestas = (new RespuestaDAOImpl().obtener_respuesta_por_id(id));
            } catch (Exception e) {
                throw new InternalServerErrorException(e.getMessage());
            }
            if (respuestas == null) {
                throw new NotFoundException("answer with id = " + id + " doesn't exist");
            }
            return respuestas;

        }


}

