package com.squad.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "streetNo", length = 10, nullable = false)
    private String streetNo;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "district", length = 20)
    private String district;

    @Column(name = "country", length = 25)
    private String country;

    @Column(name = "area", length = 25)
    private String area;

    public Address(int id, String street, String streetNo, String city, String district, String country, String area) {
        this.id = id;
        this.street = street;
        this.streetNo = streetNo;
        this.city = city;
        this.district = district;
        this.country = country;
        this.area = area;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
