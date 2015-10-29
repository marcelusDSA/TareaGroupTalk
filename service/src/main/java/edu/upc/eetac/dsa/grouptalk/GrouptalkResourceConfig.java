package edu.upc.eetac.dsa.grouptalk;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * Created by marcelus on 23/10/15.
 */
//que permite, entre otras cosas, declarar en qué paquetes se debe buscar las clases recurso raíz una vez que el
// servicio se despliega en un contenedor, en nuestro caso el servidor HTTP Grizzly.
// Recordad que al principio (y se sigue manteniendo) declaramos el paquete edu.upc.eetac.dsa.beeter como
// paquete interesante para Jersey. Será en este paquete donde implementaremos las clases recurso raíz.


public class GrouptalkResourceConfig extends ResourceConfig {

    //registro  de  paquetes en la configuración de Jersey:
    public GrouptalkResourceConfig (){
        packages("edu.upc.eetac.dsa.grouptalk");
        packages("edu.upc.eetac.dsa.beeter.auth");
        register(RolesAllowedDynamicFeature.class);
    }
}
