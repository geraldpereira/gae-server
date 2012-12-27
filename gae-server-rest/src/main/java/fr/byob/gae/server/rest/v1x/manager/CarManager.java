package fr.byob.gae.server.rest.v1x.manager;

import fr.byob.gae.server.rest.db.bean.Car;

public interface CarManager {

	public Car add(final Car car);

	public Car get(final Long id);
}
