package edu.upc.eetac.dsa.grouptalk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
// proporciona una serie de métodos de recurso que pueden procesar peticiones HTTP
// sobre las rutas a las que están asociados. En este caso, el recurso MyResource
// tiene un método de recurso getIt() que procesa peticiones HTTP GET sobre la
// URI `http://localhost:8080/myapp/myresource devolviendo la cadena de texto plano
// (cabecera HTTP Content-Type con valor text/plain) Got It.

@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
