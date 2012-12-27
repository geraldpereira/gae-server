package fr.byob.gae.server.rest.db.dao;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.inject.Inject;

import fr.byob.gae.server.rest.db.bean.Bean;

/**
 * TODO Guice it
 * 
 * @author gpereira
 * 
 */
public class TestDAO {

	@Inject
	PersistenceManagerFactory persistenceManagerFactory;

	public Bean readBean(String id) {
		PersistenceManager manager = persistenceManagerFactory.getPersistenceManager();
		try{
			return manager.getObjectById(Bean.class, id);
		}finally{
			manager.close();
		}
	}

	public void createBean(Bean bean) {
		PersistenceManager manager = persistenceManagerFactory
				.getPersistenceManager();
		try {

		} finally {
			manager.close();
		}
	}


}
