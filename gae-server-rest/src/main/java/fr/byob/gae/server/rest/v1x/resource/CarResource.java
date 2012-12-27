package fr.byob.gae.server.rest.v1x.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

import fr.byob.gae.server.commons.guice.InjectLogger;
import fr.byob.gae.server.rest.db.bean.Car;
import fr.byob.gae.server.rest.v1x.V1XConstants;
import fr.byob.gae.server.rest.v1x.manager.CarManager;

@Path(V1XConstants.PATH + "/car/")
public class CarResource {

	@InjectLogger
	private Logger log;

	@Inject
	private CarManager carManager;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/add")
	public Car add(final Car car) {
		log.info(car.toString());
		final Car savedCar = carManager.add(car);
		return savedCar;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/get/{id}")
	public Car get(@PathParam("id") final Long id) {
		log.info(id);
		return carManager.get(id);
	}

}
