package com.squad.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="idOffers", nullable=false)
    private Offer offer;

    @Column(name = "image", nullable = false)
    private Blob image;

    public Image(int id, Offer offer, Blob image) {
        this.id = id;
        this.offer = offer;
        this.image = image;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
