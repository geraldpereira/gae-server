package fr.byob.gae.server.rest.db;

import com.google.inject.AbstractModule;
import com.googlecode.objectify.ObjectifyService;

import fr.byob.gae.server.rest.db.bean.Car;
import fr.byob.gae.server.rest.db.dao.CarDAO;
import fr.byob.gae.server.rest.db.dao.impl.CarDAOImpl;

public class DAOModule extends AbstractModule {

	@Override
	protected void configure() {
		ObjectifyService.register(Car.class);
		bind(CarDAO.class).to(CarDAOImpl.class);
	}

}
