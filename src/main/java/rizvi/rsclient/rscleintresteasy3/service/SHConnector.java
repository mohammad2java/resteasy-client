package rizvi.rsclient.rscleintresteasy3.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

public interface SHConnector {
	
	@Consumes("application/xml")
	@GET
	@Path("/devzone/sysstate.html")
	public String findStatus();
	
	
	@Consumes("application/xml")
	@GET
	@Path("/devzone/sysstate.html")
	public String findShowToken(@QueryParam("devact") String devact);
	
	
	//Note --we can use almost all annotation from the pkg javax.ws.rs
	/*
	 Method level annotation.
	 --------------
	Consumes
	Produces	
	GET	
	POST	
	PUT	
	HEAD	
	DELETE
	OPTIONS	
	TRACE
	Path	
	
	Method-Arguments level annotation.
	------------------------------
	CookieParam	
	FormParam	
	HeaderParam	
	MatrixParam	
	PathParam	
	QueryParam
*/
}
