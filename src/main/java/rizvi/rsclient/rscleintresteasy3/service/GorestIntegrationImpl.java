package rizvi.rsclient.rscleintresteasy3.service;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rizvi.rsclient.rscleintresteasy3.service.integ.GoUser;
import rizvi.rsclient.rscleintresteasy3.service.integ.GorestClient;

@Component("gorestClient")
public class GorestIntegrationImpl implements GorestClient {

	private GorestClient connector;
	private ObjectMapper mapper;

	public GorestIntegrationImpl(@Value("${gorest.url}") String url) {
		super();
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		client.register(AppLoggerFilter.class);
		ResteasyWebTarget target = client.target(url);
		connector = target.proxy(GorestClient.class);
		mapper = new ObjectMapper();
	}

	@Override
	public String userList() {
		return connector.userList();
	}

	@Override
	public void createUser(String user,String token) {
		connector.createUser(user,token);
	}

	@Override
	public void createUser(GoUser user) {
		String userInString = null;
		try {
			userInString = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(userInString);
		String token = "Bearer 54dfe9965e2679036bdae20570a405fd8c3ebbea4e5935346fd9e6094fc57595";
		connector.createUser(userInString,token);
	}

}
