package fr.byob.gae.server.rest.v1x.manager;

import fr.byob.gae.server.rest.model.v1x.bean.TestRequest;
import fr.byob.gae.server.rest.model.v1x.bean.TestResult;

public interface TestManager {
	public TestResult test(final TestRequest request);
}
