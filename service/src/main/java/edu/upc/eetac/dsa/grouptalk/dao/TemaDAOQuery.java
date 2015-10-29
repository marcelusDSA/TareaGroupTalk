package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by marcelus on 25/10/15.
 */
public class TemaDAOQuery {

    public final static String UUID = "select REPLACE(UUID(),'-','')";


   /* insert into temas (id,userid,grupoid,titulo,contenido) values (555,'jordi','22','el pib','como lo hacemos para subirlo');
    Query OK, 1 row affected (0,10 sec)*/
   public final static String CREAR_TEMA = "insert into temas (id, userid, grupoid, titulo, contenido) values (UNHEX(?), ?, ?, ?, ?);";


    //mysql> select id,userid,grupoid,titulo,contenido from temas where id=111;
    public final static String OBTENER_TEMA_PORID = "select hex(id) as id, userid, grupoid, titulo, contenido from temas where id=unhex(?);";

    public final static String OBTENER_TEMAS_POR_GRUPIID = "select hex(id) as id, userid, titulo, contenido from temas where grupoid=?;";


    public final static String OBTENER_USERID_POR_LOGINIG = "select hex(temas.id) as id, temas.userid, temas.grupoid, temas.titulo, temas.contenido from temas where temas.userid=?";

    public final static String ACTUALIZAR_TEMA = "update temas set contenido=? where id=UNHEX(?);";
                                                                                                                //OOOJJOOOOOOOOOOO//
/*> select temas.id, temas.userid, temas.grupoid, temas.titulo, temas.contenido from temas where temas.userid='marcelus';
+-----+----------+---------+------------------+-------------------------------+
| id  | userid   | grupoid | titulo           | contenido                     |
+-----+----------+---------+------------------+-------------------------------+
| 111 | marcelus | 11      | podemos          | son los mejores               |
| 222 | marcelus | 11      | el caso barcenas | es un puto ladron, que pinan? |
+-----+----------+---------+------------------+-------------------------------+*/


    public final static String OBTENER_USERID_DE_USER= "select loginid from users where loginid=?;";

    public final static String ELIMINAR_TEMA = "delete from temas where id=unhex(?);";
}
