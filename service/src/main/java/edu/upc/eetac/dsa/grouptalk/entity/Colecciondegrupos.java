package edu.upc.eetac.dsa.grouptalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelus on 24/10/15.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Colecciondegrupos {

    @InjectLinks({})
    private List<Link> links;
    private List<Grupos> grupos  = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Grupos> getGrupos() {
        return grupos;
    }
    public void setGrupos(List<Grupos> grupos) {
        this.grupos = grupos;
    }
}
