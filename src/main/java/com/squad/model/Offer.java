package com.squad.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer implements java.io.Serializable {
    @Column(name = "type")

    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Feature feature;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinTable(name = "images", joinColumns = { @JoinColumn(name = "idOffers") })
    List<Image> images;


    @Column(name = "price")
    private String price;
    @Column(name = "idAddresses")
    private int idAddresses;
    @Column(name = "emailUser")
    private String emailUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public Offer(String type, Feature feature, String price, int idAddresses, String emailUser, int id) {
        this.type = type;
        this.feature = feature;
        this.price = price;
        this.idAddresses = idAddresses;
        this.emailUser = emailUser;
        this.id = id;
    }

    public Offer() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIdAddresses() {
        return idAddresses;
    }

    public void setIdAddresses(int idAddresses) {
        this.idAddresses = idAddresses;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
