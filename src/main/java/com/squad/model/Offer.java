package com.squad.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Offer implements java.io.Serializable {
    @Column(name = "type")
    private String type;
    @Column(name = "idFeatures")
    private int idFeatures;
    @Column(name = "price")
    private String price;
    @Column(name = "idAddresses")
    private int idAddresses;
    @Column(name = "emailUser")
    private String emailUser;
    @Id
    @Column(name = "idOffers")
    private int idOffers;

    public Offer() {

    }

    public Offer(String type, int idFeatures, String price, int idAddresses, String emailUser, int idOffers) {
        this.type = type;
        this.idFeatures = idFeatures;
        this.price = price;
        this.idAddresses = idAddresses;
        this.emailUser = emailUser;
        this.idOffers = idOffers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdOffers() {
        return idOffers;
    }

    public void setIdOffers(int idOffers) {
        this.idOffers = idOffers;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getIdAddresses() {
        return idAddresses;
    }

    public void setIdAddresses(int idAddresses) {
        this.idAddresses = idAddresses;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIdFeatures() {
        return idFeatures;
    }

    public void setIdFeatures(int idFeatures) {
        this.idFeatures = idFeatures;
    }
}
