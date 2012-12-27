package fr.byob.gae.server.rest.v1x.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

import fr.byob.gae.server.commons.guice.InjectLogger;
import fr.byob.gae.server.rest.model.v1x.bean.TestRequest;
import fr.byob.gae.server.rest.model.v1x.bean.TestResult;
import fr.byob.gae.server.rest.v1x.V1XConstants;
import fr.byob.gae.server.rest.v1x.manager.TestManager;

@Path(V1XConstants.PATH + "/test/")
public class TestResource {

	@InjectLogger
	private Logger log;

	@Inject
	private TestManager testManager;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/test")
	public TestResult test(final TestRequest request) {
		log.info(request.toString());
		final TestResult result = testManager.test(request);
		return result;
	}

}
