package fr.byob.gae.server.rest.v1x.manager.impl;

import com.google.inject.Inject;

import fr.byob.gae.server.rest.db.bean.Car;
import fr.byob.gae.server.rest.db.dao.CarDAO;
import fr.byob.gae.server.rest.v1x.manager.CarManager;

public class CarManagerImpl implements CarManager {

	@Inject
	private CarDAO carDAO;

	public Car add(Car car) {
		carDAO.addCar(car);
		return car;
	}

	public Car get(Long id) {
		return carDAO.getCar(id);
	}

}
