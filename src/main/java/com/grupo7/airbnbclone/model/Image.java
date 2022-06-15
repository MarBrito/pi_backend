package com.grupo7.airbnbclone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String headerImage;

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "images-setofimages")
    private Set<SetOfImages> setOfImagesSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    @JsonBackReference(value = "accommodation-image")
    private Accommodation accommodation;

    public Image() {
    }

    public Image(Integer id, String headerImage, Set<SetOfImages> setOfImagesSet, Accommodation accommodation) {
        this.id = id;
        this.headerImage = headerImage;
        this.setOfImagesSet = setOfImagesSet;
        this.accommodation = accommodation;
    }

    public Image(String headerImage, Set<SetOfImages> setOfImagesSet, Accommodation accommodation) {
        this.headerImage = headerImage;
        this.setOfImagesSet = setOfImagesSet;
        this.accommodation = accommodation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public Set<SetOfImages> getSetOfImagesSet() {
        return setOfImagesSet;
    }

    public void setSetOfImagesSet(Set<SetOfImages> setOfImagesSet) {
        this.setOfImagesSet = setOfImagesSet;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }



}
