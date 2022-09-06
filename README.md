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
public interface GorestClient {

	@GET
	@Path("/public/v2/users")
	String userList();

	@POST
	@Path("/public/v2/users")
	@Consumes("application/json")
	void createUser(String user, @HeaderParam("Authorization") String token);

}
			
step-3
---------
 IMPL class to wrapp inteface
@Component("gorestClient")
public class GorestIntegrationImpl implements GorestClient {
	private GorestClient connector;
	private ObjectMapper mapper;

	public GorestIntegrationImpl(@Value("${gorest.url}") String url) {
		super();
		ResteasyClient client = new ResteasyClientBuilder().build();
		client.register(AppLoggerFilter.class);  //added filter to logging request
		ResteasyWebTarget target = client.target(url);
		connector = target.proxy(GorestClient.class);
		mapper = new ObjectMapper();  //added mapper for object to json & json to object
	}
	
	
	
step-4:
inject this where you want to call GorestClient

	
	
   logging request & response for all request
   -------------------------------------------
		   
		   
		   public class AppLoggerFilter implements ClientRequestFilter, ClientResponseFilter
			
		   
	
	
	
	
		
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
	
