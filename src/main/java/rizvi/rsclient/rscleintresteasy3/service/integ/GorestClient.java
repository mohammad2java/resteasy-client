package rizvi.rsclient.rscleintresteasy3.service.integ;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface GorestClient {

	@GET
	@Path("/public/v2/users")
	String userList();

	@POST
	@Path("/public/v2/users")
	@Consumes("application/json")
	void createUser(String user, @HeaderParam("Authorization") String token);

	void createUser(GoUser user);

}
