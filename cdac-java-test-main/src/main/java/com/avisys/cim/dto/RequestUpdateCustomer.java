package com.avisys.cim.dto;

public class RequestUpdateCustomer {

	private Long id;
	
	private String number;

	public RequestUpdateCustomer(Long id, String number) {
		super();
		this.id = id;
		this.number = number;
	}
	public RequestUpdateCustomer() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}