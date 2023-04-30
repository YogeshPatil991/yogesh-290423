package com.avisys.cim.dto;

public class RequestMobille {

	private String number;

	public RequestMobille(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "RequestMobille [number=" + number + "]";
	}
	
	
}
