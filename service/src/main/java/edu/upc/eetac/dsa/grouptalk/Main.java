package edu.upc.eetac.dsa.grouptalk;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on


    private static String baseURI;// le pasamos la nueva propiedad que tenemos en properties con el metodo getBaseURI()

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // configura a Jersey para buscar clases recursos en el paquete base edu.upc.eetac.dsa.grouptalk


       // final ResourceConfig rc = new ResourceConfig().packages("edu.upc.eetac.dsa.grouptalk"); esto se hacia cuando no teniamos
        //la heredera grouptalkResourceConf de ResourceConnfig

        final ResourceConfig rc = new GrouptalkResourceConfig();
        //crea el contenedor Grizzly y configura al servicio para una URI base declarada como la constante BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(getBaseURI()), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", getBaseURI()));
            System.in.read();
        server.shutdownNow();
    }

    public static String getBaseURI() {
        if (baseURI == null) {
            PropertyResourceBundle prb = (PropertyResourceBundle) ResourceBundle.getBundle("grouptalk");
            baseURI = prb.getString("grouptalk.context");
        }
        return baseURI;
    }
}

