package fr.byob.gae.server.rest.db.bean;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Car {

	@Id
	private Long id;
	private String vin;
	private int color;
	@Transient
	private String doNotPersist;

	public Car() {
	}

	public Car(String vin, int color) {
		this.vin = vin;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getDoNotPersist() {
		return doNotPersist;
	}

	public void setDoNotPersist(String doNotPersist) {
		this.doNotPersist = doNotPersist;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", vin=" + vin + ", color=" + color
				+ ", doNotPersist=" + doNotPersist + "]";
	}
	
}
