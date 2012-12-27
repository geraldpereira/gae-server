package fr.byob.gae.server.rest.db.dao;

import fr.byob.gae.server.rest.db.bean.Car;

public interface CarDAO {

	public void addCar(Car car);

	public Car getCar(Long id);

	public void deleteCar(Car car);

	public void updateCar(Car car);
}
