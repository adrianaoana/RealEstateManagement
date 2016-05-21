package com.squad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements java.io.Serializable {

	@Id
	@Column(name = "email", length = 60, nullable = false)
	private String email;

	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@Column(name = "first_name", length = 45)
	private String firstName;

	@Column(name = "last_name", length = 45)
	private String lastName;

	@Column(name = "street_nr", length = 10)
	private String streetNr;

	@Column(name = "street", length = 50)
	private String street;

	@Column(name = "city", length = 20)
	private String city;

	@Column(name = "district", length = 20)
	private String district;

	@Column(name = "country", length = 25)
	private String country;

	@Column(name = "phone", length = 14)
	private String phone;

	@Column(name = "role", length = 15)
	private String role;

	public User() {
	}

	public User(String email, String password, String firstName, String lastName, String streetNr, String street,
			String city, String district, String country, String phone, String role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetNr = streetNr;
		this.street = street;
		this.city = city;
		this.district = district;
		this.country = country;
		this.phone = phone;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String getStreetNr() {
		return streetNr;
	}

	public void setStreetNr(String streetNr) {
		this.streetNr = streetNr;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}