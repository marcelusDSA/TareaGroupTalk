package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.entity.GrouptalkError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by marcelus on 25/10/15.
 */
public class ThrowableMapper implements ExceptionMapper<Throwable> {
    @Override
        public Response toResponse(Throwable throwable) {
            throwable.printStackTrace();
            GrouptalkError error = new GrouptalkError(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), throwable.getMessage());
            return Response.status(error.getStatus()).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
        }
    }

