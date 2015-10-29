package edu.upc.eetac.dsa.grouptalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by marcelus on 23/10/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    //una lista de elementos de tipo javax.ws.rs.core.Link
    // que es la clase que define JAX-RS para modelar un hyperenlace del servicio.

    @InjectLinks({})
    private List<Link> links;
    //Link que utilizáis es la javax.ws.rs.core.Link.
    private String id;
    private String loginid;
    private String email;
    private String fullname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
