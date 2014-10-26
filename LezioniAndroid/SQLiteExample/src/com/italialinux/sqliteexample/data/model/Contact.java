package com.italialinux.sqliteexample.data.model;

public class Contact {
	
	private long id;
	private String contact_name;
	private String number;
	
	public Contact(long id, String contact_name, String number) {
		super();
		this.id = id;
		this.contact_name = contact_name;
		this.number = number;
	}
	
	public Contact(String contact_name, String number) {
		super();
		this.contact_name = contact_name;
		this.number = number;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	} 
}
