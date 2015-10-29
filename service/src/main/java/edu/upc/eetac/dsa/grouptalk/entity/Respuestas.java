package edu.upc.eetac.dsa.grouptalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by marcelus on 23/10/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Respuestas {
    @InjectLinks({})
    private List<Link> links;
    private  String id;
    private  String userid;
    private  String temaid;
    private  String respuesta;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getTemaid() {
        return temaid;
    }

    public void setTemaid(String temaid) {
        this.temaid = temaid;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
