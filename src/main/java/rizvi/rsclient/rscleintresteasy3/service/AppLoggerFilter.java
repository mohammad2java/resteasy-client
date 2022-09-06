package rizvi.rsclient.rscleintresteasy3.service;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.StatusType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLoggerFilter implements ClientRequestFilter, ClientResponseFilter {
	static final Logger logger = LoggerFactory.getLogger(AppLoggerFilter.class);

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {

		URI uri = requestContext.getUri();
		Object entity = requestContext.getEntity();
		MultivaluedMap<String, Object> headers = requestContext.getHeaders();

		logger.info("URI:{},Entity:{} headers:{}", uri, entity, headers);
	}

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		StatusType statusInfo = responseContext.getStatusInfo();
		logger.info("statusInfo: {}", statusInfo);
	}
}