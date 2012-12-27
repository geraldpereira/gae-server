package fr.byob.gae.server.rest.db;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.google.inject.AbstractModule;

public class DAOModule extends AbstractModule{

	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	@Override
	protected void configure() {
		bind(PersistenceManagerFactory.class).toInstance(pmfInstance);
		// bind(PersistenceManager.class).toProvider(
		// new Provider<PersistenceManager>() {
		//
		// @Override
		// public PersistenceManager get() {
		// return pmfInstance.getPersistenceManager();
		// }
		// });

	}

}
