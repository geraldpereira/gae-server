package fr.byob.gae.server.rest.v1x.manager.impl;

import fr.byob.gae.server.rest.model.v1x.bean.TestRequest;
import fr.byob.gae.server.rest.model.v1x.bean.TestResult;
import fr.byob.gae.server.rest.v1x.manager.TestManager;

public class TestManagerImpl implements TestManager {

	public TestResult test(TestRequest request) {
		TestResult result = new TestResult();
		result.setValue(request.getValue() + " tested!");
		return result;
	}

}
