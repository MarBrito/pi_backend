package com.grupo7.airbnbclone.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    private String categoryDescription;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "category-accommodation")
    private Set<Accommodation> accommodationSet = new HashSet<>();

    public Category() {
    }

    public Category(Integer id, String categoryName, String categoryDescription, Set<Accommodation> accommodationSet) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.accommodationSet = accommodationSet;
    }

    public Category(String categoryName, String categoryDescription, Set<Accommodation> accommodationSet) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.accommodationSet = accommodationSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Set<Accommodation> getAccommodationSet() {
        return accommodationSet;
    }

    public void setAccommodationSet(Set<Accommodation> accommodationSet) {
        this.accommodationSet = accommodationSet;
    }
}
