package com.squad.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "feature")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "idOffers")
    private Integer offerId;

    @Column(name = "image", nullable = false)
    private Blob image;

    public Image(int id, Integer offerId, Blob image) {
        this.id = id;
        this.offerId = offerId;
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

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
