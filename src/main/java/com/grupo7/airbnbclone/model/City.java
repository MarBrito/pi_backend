package com.grupo7.airbnbclone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cityName;
    private String cityState;
    private String cityCountry;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "city-accommodation")
    private Set<Accommodation> accommodations = new HashSet<>();


    public City() {
    }

    public City(Integer id, String cityName, String cityState, String cityCountry, Set<Accommodation> accommodations) {
        this.id = id;
        this.cityName = cityName;
        this.cityState = cityState;
        this.cityCountry = cityCountry;
        this.accommodations = accommodations;
    }

    public City(String cityName, String cityState, String cityCountry, Set<Accommodation> accommodations) {
        this.cityName = cityName;
        this.cityState = cityState;
        this.cityCountry = cityCountry;
        this.accommodations = accommodations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityState() {
        return cityState;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public void setCityCountry(String cityCountry) {
        this.cityCountry = cityCountry;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }
}
