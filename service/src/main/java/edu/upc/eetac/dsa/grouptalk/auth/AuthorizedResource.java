package edu.upc.eetac.dsa.grouptalk.auth;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by marcelus on 25/10/15.
 */
public class AuthorizedResource {

   // que modela el objeto JSON que contiene el array JSON definido en el fichero:

    private String path;
    private List<String> methods;
    private Pattern pattern;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        pattern = Pattern.compile(path);
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
