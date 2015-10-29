package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by marcelus on 24/10/15.
 */
public class    GrupoDAOQuery {
    public final static String GET_GRUPOS = "select id,tipodegrupo from grupos";
    //ejemplo:
    /*mysql> select id,tipodegrupo from grupos;
    +----+-------------+
            | id | tipodegrupo |
            +----+-------------+
            | 11 | politica    |
            | 22 | economia    |
            +----+-------------+*/
    public  final static  String OBTENER_TEMAS_DE_GRUPO_POR_ID= "select userid, titulo, contenido  from temas grupoid=?;";
  /* mysql> select temas.userid,temas.id,temas.titulo, temas.contenido, grupos.tipodegrupo from temas, grupos where  grupos.id=11;
+----------+-----+------------------+------------------------------------+-------------+
| userid   | id  | titulo           | contenido                          | tipodegrupo |
+----------+-----+------------------+------------------------------------+-------------+
| marcelus | 111 | podemos          | son los mejores                    | politica    |
| marcelus | 222 | el caso barcenas | es un puto ladron, que pinan?      | politica    |
| molina   | 333 | el caso noss     | fuera la monarquia por esto        | politica    |
| jordi    | 444 | la crisis        | si gana podemos no tedremos crisis | politica    |
+----------+-----+------------------+------------------------------------+-------------+
*/


  public  final static  String OBTENER_RESPUESTAS_DE_TEMA_POR_ID= "select respuestas.temaid, respuestas.respuesta, respuestas.userid from temas, respuestas where temas.id=unhex(?) and respuestas.temaid=unhex(?)";
    /*mysql> select temas.titulo, temas.contenido, respuestas.respuesta, respuestas.userid from temas, respuestas where temas.id=111 and respuestas.temaid=111;
+---------+-----------------+------------------------------------------------+----------+
| titulo  | contenido       | respuesta                                      | userid   |
+---------+-----------------+------------------------------------------------+----------+
| podemos | son los mejores | yo creo que son mojores los de ciudadanos      | jordi    |
| podemos | son los mejores | pues a mi me parece que son mejores los del pp | molina   |
| podemos | son los mejores | pues para mi el PSOE                           | marcelus |
| podemos | son los mejores | te lo voy a repetir pues para mi el PSOE       | marcelus |
+---------+-----------------+------------------------------------------------+----------+*/
}
