package edu.upc.eetac.dsa.grouptalk;

/**
 * Created by marcelus on 25/10/15.
 */

//Interfaz para los tipos de contenido


public interface GrouptalkMediaType {
    public final static String BEETER_AUTH_TOKEN = "application/vnd.dsa.grouptalk.auth-token+json";
    public final static String BEETER_USER = "application/vnd.dsa.grouptalk.user+json";
    public final static String BEETER_GRUPO = "application/vnd.dsa.grouptalk.grupos+json";
    public final static String BEETER_TEMA = "application/vnd.dsa.grouptalk.temas+json";
    public final static String BEETER_RESPUESTA = "application/vnd.dsa.grouptalk.respuestas+json";
    public final static String BEETER_TEMAS_COLECCION = "application/vnd.dsa.grouptalk.temas.coleccion+json";
    public final static String BEETER_RESPUESTAS_COLECCION = "application/vnd.dsa.grouptalk.temas.coleccion+json";
    public final static String BEETER_ROOT = "application/vnd.dsa.grouptalk.root+json";
}
