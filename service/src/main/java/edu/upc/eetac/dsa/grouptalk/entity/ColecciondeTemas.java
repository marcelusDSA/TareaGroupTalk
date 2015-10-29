package edu.upc.eetac.dsa.grouptalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelus on 23/10/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColecciondeTemas {

    @InjectLinks({})
    private List<Link> links;
    private List<Temas> temas  = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Temas> getTemas() {
        return temas;
    }

    public void setTemas(List<Temas> temas) {
        this.temas = temas;
    }
}
