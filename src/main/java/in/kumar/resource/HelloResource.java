package in.kumar.resource;

import in.kumar.dao.HelloDao;
import in.kumar.models.Hello;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.yammer.dropwizard.testing.JsonHelpers.*;
import static javax.ws.rs.core.Response.ok;

/**
 * Created with IntelliJ IDEA.
 * User: kumar
 * Date: 30/4/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    public HelloDao helloDao;

    public HelloResource(HelloDao helloDao){
        this.helloDao = helloDao;
    }

    @GET
    @Path("/{name}")
    public Response sayHello(@PathParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setGreetings("Hai, " + name);
        return ok().entity(hello).build();
    }

    @POST
    public Response saveGreetings(String payload) throws IOException {
        Map<String,String> helloMap = fromJson(payload, HashMap.class);
        Hello hello = new Hello();
        hello.setName(helloMap.get("name"));
        hello.setGreetings(helloMap.get("greetings"));
        helloDao.save(hello);
        return ok().build();
    }

}
