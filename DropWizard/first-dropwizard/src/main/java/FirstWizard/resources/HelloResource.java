package FirstWizard.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author - yogesh
 */

@Path("/hello-world")
public class HelloResource {
    @GET
    public String get(){
        return "Welcome, it's good to see you :-)";
    }
}
