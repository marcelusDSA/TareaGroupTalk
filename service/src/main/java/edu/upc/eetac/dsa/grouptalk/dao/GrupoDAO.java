package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Colecciondegrupos;
import edu.upc.eetac.dsa.grouptalk.entity.Grupos;
import edu.upc.eetac.dsa.grouptalk.entity.Respuestas;
import edu.upc.eetac.dsa.grouptalk.entity.Temas;

import java.sql.SQLException;

/**
 * Created by marcelus on 24/10/15.
 */
public interface GrupoDAO {


    public Colecciondegrupos obtenercolecciondegrupos();
}