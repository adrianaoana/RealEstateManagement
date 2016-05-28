package com.squad.model;


import javax.persistence.*;

@Entity
@Table(name = "feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "propetyType", length = 25)
    private String propertyType;

    @Column(name = "devision", length = 25)
    private String division;

    @Column(name = "confort", length = 25)
    private String comfort;

    @Column(name = "floor", nullable = false)
    private int floor;

    @Column(name = "usableSurface", nullable = false)
    private double usableSurface;

    @Column(name = "balconyNo", nullable = false)
    private int balconyNo;

    @Column(name = "roomNo", nullable = false)
    private int roomNo;

    @Column(name = "kitchenNo", nullable = false)
    private int kitchenNo;

    @Column(name = "garrage")
    private Boolean garage;

    @Column(name = "parkingPlaces", nullable = false)
    private int parkingPlaces;

    public Feature(int featureId, String propertyType, String division, String comfort, int floor, double usableSurface, int balconyNo, int roomNo, int kitchenNo, Boolean garage, int parkingPlaces) {
        this.id = featureId;
        this.propertyType = propertyType;
        this.division = division;
        this.comfort = comfort;
        this.floor = floor;
        this.usableSurface = usableSurface;
        this.balconyNo = balconyNo;
        this.roomNo = roomNo;
        this.kitchenNo = kitchenNo;
        this.garage = garage;
        this.parkingPlaces = parkingPlaces;
    }

    public Feature() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getUsableSurface() {
        return usableSurface;
    }

    public void setUsableSurface(double usableSurface) {
        this.usableSurface = usableSurface;
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

    public Boolean getGarage() {
        return garage;
    }

    public void setGarage(Boolean garage) {
        this.garage = garage;
    }

    public int getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(int parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }
}
