package rizvi.rsclient.rscleintresteasy3.service;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import rizvi.rsclient.rscleintresteasy3.service.integ.QuraanConnector;

@Component("quraanConnector")
public class QuraanConnImpl implements QuraanConnector {

	private QuraanConnector connector = null;

	Logger log = LoggerFactory.getLogger(this.getClass());

	public QuraanConnImpl(@Value("${quran.url}") String url) {
		super();
		ResteasyClient client = new ResteasyClientBuilder().build();
		client.register(AppLoggerFilter.class);
		ResteasyWebTarget target = client.target(url);
		connector = target.proxy(QuraanConnector.class);
	}


	@Override
	public String chapterList(String lang) {
		log.info("getting call");
		return connector.chapterList(lang);
	}

}
