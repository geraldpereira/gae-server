package fr.byob.gae.server.rest.v1x.resource;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fr.byob.gae.server.commons.guice.LoggerModule;
import fr.byob.gae.server.rest.RESTJerseyServletModule;
import fr.byob.gae.server.rest.db.DAOModule;
import fr.byob.gae.server.rest.model.v1x.bean.TestRequest;
import fr.byob.gae.server.rest.model.v1x.bean.TestResult;

public class TestResourceTest {

	private TestResource testResource;
	private static Injector injector;

	@BeforeClass
	public static void beforeClass() {
		injector = Guice.createInjector(new LoggerModule(),
				new RESTJerseyServletModule(), new DAOModule());

	}

	@Before
	public void before() {
		testResource = injector.getInstance(TestResource.class);
		Assert.assertNotNull(testResource);
	}

	@Test
	public void test() {
		final TestRequest request = new TestRequest();
		request.setValue("niak niak");

		final TestResult result = testResource.test(request);

		Assert.assertEquals("niak niak tested!", result.getValue());
	}

}
