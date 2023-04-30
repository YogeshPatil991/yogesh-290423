package com.avisys.cim.dto;

import java.util.List;

public class RequestCustomer {

	private String firstName;
	
	private String lastName;
	
	private List<RequestMobille> requestMobille;

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<RequestMobille> getRequestMobille() {
		return requestMobille;
	}

	public void setRequestMobille(List<RequestMobille> requestMobille) {
		this.requestMobille = requestMobille;
	}
	
	
	
	
}
