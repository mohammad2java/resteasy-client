HOW to make REST-CLIENT using RestEasy-Jboss framework(Proxy-Object-Approach)
-----------------------------------------------------------------------------
step-1
------
create spring boot project using following dependency

		<dependency>
			<groupId>org.jboss.resteasy</groupId>
			<artifactId>resteasy-client</artifactId>
			<version>3.6.3.Final</version>
		</dependency>
		
step-2
--------
create interface for proxy object and declare method using jaxrs api annotation.

Example:
----------
	public interface SHConnector {
	
			@Consumes("application/xml")
			@GET
			@Path("/devzone/sysstate.html")
			public String findStatus();
			
			
			@Consumes("application/xml")
			@GET
			@Path("/devzone/sysstate.html")
			public String findShowToken(@QueryParam("devact") String devact);
	}		
	
	
	more example:
	---------------
	public interface SimpleClient
		{
		   @GET
		   @Path("basic")
		   @Produces("text/plain")
		   String getBasic();

		   @PUT
		   @Path("basic")
		   @Consumes("text/plain")
		   void putBasic(String body);

		   @GET
		   @Path("queryParam")
		   @Produces("text/plain")
		   String getQueryParam(@QueryParam("param")String param);

		   @GET
		   @Path("matrixParam")
		   @Produces("text/plain")
		   String getMatrixParam(@MatrixParam("param")String param);

		   @GET
		   @Path("uriParam/{param}")
		   @Produces("text/plain")
		   int getUriParam(@PathParam("param")int param); 
		   }
	
	
Here you can use all param annotation-
-------------------------------------
	CookieParam	
	FormParam	
	HeaderParam	
	MatrixParam	
	PathParam	
	QueryParam
	

step-3
-----------

create Impl class for interface and create proxy object in default constructor.

example:
----------
	@Component
	public class SHConnectorImpl implements SHConnector {
		private SHConnector shConnector =  null;		
		public SHConnectorImpl() {
			super();
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8088/");
			shConnector = target.proxy(SHConnector.class);
		}
		@Override
		public String findStatus() {
			return shConnector.findStatus();
		}
		@Override
		public String findShowToken(String devact) {
			return shConnector.findShowToken(devact);
		}
	}

	
step-4
---------
inject IMPL class whenevr you want to call these methods.
