package com.squad.model;

import org.springframework.web.multipart.MultipartFile;

public class MyObject {
    private double usableSurface;
    private String division;
    private int balconyNo;
    private int roomNo;
    private int kitchenNo;
    private int parkingPlaces;
    private boolean garage;
    private String propertyType;
    private String detail;
    private int bathroomNo;
    private String confort;
    private int floor;
    private String type;
    private String price;
    private MultipartFile image;
    private String street;
    private String streetNo;
    private String district;
    private String country;
    private String city;
    private String area;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getBathroomNo() {

        return bathroomNo;
    }

    public void setBathroomNo(int bathroomNo) {
        this.bathroomNo = bathroomNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public double getUsableSurface() {
        return usableSurface;
    }

    public void setUsableSurface(double usableSurface) {
        this.usableSurface = usableSurface;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getBalconyNo() {
        return balconyNo;
    }

    public void setBalconyNo(int balconyNo) {
        this.balconyNo = balconyNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getKitchenNo() {
        return kitchenNo;
    }

    public void setKitchenNo(int kitchenNo) {
        this.kitchenNo = kitchenNo;
    }

    public int getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(int parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getConfort() {
        return confort;
    }

    public void setConfort(String confort) {
        this.confort = confort;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
