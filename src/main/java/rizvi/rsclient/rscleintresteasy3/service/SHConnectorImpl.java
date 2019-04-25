package rizvi.rsclient.rscleintresteasy3.service;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;

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
