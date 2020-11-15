package org.jp.passenger.travel.batch.utility;

public enum Status {

	OK("OK");

	private String value;

	Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
