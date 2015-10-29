package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.ColecciondeTemas;
import edu.upc.eetac.dsa.grouptalk.entity.Grupos;
import edu.upc.eetac.dsa.grouptalk.entity.Temas;
import edu.upc.eetac.dsa.grouptalk.entity.User;

import java.sql.SQLException;

/**
 * Created by marcelus on 25/10/15.
 */
public interface TemaDAO {
    public Temas creartema (String userid, String grupoid, String titulo, String contenido ) throws SQLException;
    public Temas obtenertema_por_temaid (String id ) throws SQLException;
    public ColecciondeTemas obtener_coleccion_temas(String grupoid);
    public Temas actualizarTema(String id, String contenido) throws SQLException;
    public boolean eliminarTemas(String id) throws SQLException;

}
