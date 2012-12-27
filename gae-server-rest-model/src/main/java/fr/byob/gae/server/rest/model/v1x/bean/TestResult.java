package fr.byob.gae.server.rest.model.v1x.bean;


public class TestResult {
	private String value;

	/**
	 * Used by dozer and JAXB to initialize bean
	 */
	public TestResult() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TestResult [value=" + value + "]";
	}

}
