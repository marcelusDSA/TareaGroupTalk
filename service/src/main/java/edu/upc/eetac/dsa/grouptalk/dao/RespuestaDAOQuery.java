package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by marcelus on 25/10/15.
 */
public class RespuestaDAOQuery {


    public final static String UUID = "select REPLACE(UUID(),'-','')";

    public final static String CREAR_RESPUESTA= "insert into respuestas (id, userid, temaid, respuesta) values (UNHEX(?), ?, UNHEX(?), ?);";
   /* insert into respuestas (id,userid,grupoid,temaid,respuesta) values (7777,'jordi','11',333,'hay que gastar mas para aumentarlo');
    Query OK, 1 row affected (0,03 sec)*/


    //select userid,grupoid,temaid,respuesta from respuestas where id =6666
    public final static String OBTENER_RESPUESTA_PORID = "select hex(id) as id, userid, hex(temaid) as temaid, respuesta from respuestas where id=unhex(?);";

}
