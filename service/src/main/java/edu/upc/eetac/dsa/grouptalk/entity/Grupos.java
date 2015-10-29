package edu.upc.eetac.dsa.grouptalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by marcelus on 23/10/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Grupos {

    @InjectLinks({})
    private List<Link> links;
    private String  id;
    private  String tipodegrupo;




    public String getTipodegrupo() {
        return tipodegrupo;
    }

    public void setTipodegrupo(String tipodegrupo) {
        this.tipodegrupo = tipodegrupo;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
