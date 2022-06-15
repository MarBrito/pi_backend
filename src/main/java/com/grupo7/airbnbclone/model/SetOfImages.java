package com.grupo7.airbnbclone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class SetOfImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameOfSetOfImages;

    @ElementCollection
    private Set<String> linksOfSetOfImages = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "image_id", referencedColumnName = "id")
    @JsonBackReference(value = "images-setofimages")
    private Image image;

    public SetOfImages() {
    }

    public SetOfImages(Integer id, String nameOfSetOfImages, Set<String> linksOfSetOfImages, Image image) {
        this.id = id;
        this.nameOfSetOfImages = nameOfSetOfImages;
        this.linksOfSetOfImages = linksOfSetOfImages;
        this.image = image;
    }

    public SetOfImages(String nameOfSetOfImages, Set<String> linksOfSetOfImages, Image image) {
        this.nameOfSetOfImages = nameOfSetOfImages;
        this.linksOfSetOfImages = linksOfSetOfImages;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfSetOfImages() {
        return nameOfSetOfImages;
    }

    public void setNameOfSetOfImages(String nameOfSetOfImages) {
        this.nameOfSetOfImages = nameOfSetOfImages;
    }

    public Set<String> getLinksOfSetOfImages() {
        return linksOfSetOfImages;
    }

    public void setLinksOfSetOfImages(Set<String> linksOfSetOfImages) {
        this.linksOfSetOfImages = linksOfSetOfImages;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
