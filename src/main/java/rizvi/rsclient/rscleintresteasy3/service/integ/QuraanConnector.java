package rizvi.rsclient.rscleintresteasy3.service.integ;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

public interface QuraanConnector {
	@GET
	@Path("/api/v4/chapters")
	String chapterList(@QueryParam("language") String param);

	
	

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
