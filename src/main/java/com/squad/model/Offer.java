package com.squad.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer implements java.io.Serializable {

	@Column(name = "type")
	private String type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idFeatures", nullable = false)
	private Feature feature;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idAddresses", nullable = false)
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "offer", fetch = FetchType.EAGER)
	List<Image> images;

	@Column(name = "price")
	private String price;

	@Column(name = "emailUser")
	private String emailUser;

	@DateTimeFormat(iso = ISO.NONE)
	@Temporal(TemporalType.DATE)
	@Column(name = "date_added")
	private Date dateAdded;

	@DateTimeFormat(iso = ISO.NONE)
	@Temporal(TemporalType.DATE)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	public Offer(String type, Feature feature, Address address, List<Image> images, String price, String emailUser,
			int id) {
		this.type = type;
		this.feature = feature;
		this.address = address;
		this.images = images;
		this.price = price;
		this.emailUser = emailUser;
		this.id = id;
	}

	public Offer() {
	}
	
	public Offer(String type, String price, String emailUser, Date dateAdded, Feature feature, Address address, int id) {
		super();
		this.type = type;
		this.price = price;
		this.emailUser = emailUser;
		this.dateAdded = dateAdded;
		this.feature = feature;
		this.address = address;
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
