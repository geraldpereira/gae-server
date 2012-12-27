package fr.byob.gae.server.rest.model.v1x.bean;

public class TestRequest {
	private String value;

	/**
	 * Used by dozer and JAXB to initialize bean
	 */
	public TestRequest() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TestResquest [value=" + value + "]";
	}
}
