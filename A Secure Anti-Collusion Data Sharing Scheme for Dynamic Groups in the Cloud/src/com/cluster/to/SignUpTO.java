package com.cluster.to;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */

public class SignUpTO {

	private int id;

	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String password;
	private String location;
	private String status;

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
