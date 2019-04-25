package rizvi.rsclient.rscleintresteasy3.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface AppnameRestService {

	@GET
	@Consumes("application/xml")
	@Path("/index.htm")
	public String getHomePage();

	@GET
	@Consumes("application/xml")
	@Path("/java_technology_tutorials.htm")
	public String getJavaPage();

}
