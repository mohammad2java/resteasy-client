package rizvi.rsclient.rscleintresteasy3.service;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;

@Component
public class AppnameRestServiceImpl implements AppnameRestService {

	private AppnameRestService service = null;

	public AppnameRestServiceImpl() {
		super();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("https://www.tutorialspoint.com");
		service = target.proxy(AppnameRestService.class);
	}

	@Override
	public String getHomePage() {
		return service.getHomePage();
	}

	@Override
	public String getJavaPage() {
		return service.getJavaPage();
	}

}
