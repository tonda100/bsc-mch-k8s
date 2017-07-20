import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Antonin Stoklasek
 */
@Path("info")
public class InfoResource {


    @GET
    public Response getInfo(){
        return Response.ok().entity("VERSION FIVE\n").build();
    }
}
