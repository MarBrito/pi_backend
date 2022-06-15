package com.grupo7.airbnbclone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accoName;
    private String accoDescription;
    private Integer accoRoomNumber;
    private Integer accoRoomGuests;
    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "accommodation-image")
    private Set<Image> imagens = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    //@JsonBackReference(value = "reservation-accommodation")
    private Set<Reservation> reservationSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference(value = "category-accommodation")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @JsonBackReference(value = "city-accommodation")
    private City city;

    public Accommodation() {
    }

    public Accommodation(Integer id, String accoName, String accoDescription, Integer accoRoomNumber, Integer accoRoomGuests, Set<Image> imagens, Set<Reservation> reservationSet, Category category, City city) {
        this.id = id;
        this.accoName = accoName;
        this.accoDescription = accoDescription;
        this.accoRoomNumber = accoRoomNumber;
        this.accoRoomGuests = accoRoomGuests;
        this.imagens = imagens;
        this.reservationSet = reservationSet;
        this.category = category;
        this.city = city;
    }

    public Accommodation(String accoName, String accoDescription, Integer accoRoomNumber, Integer accoRoomGuests, Set<Image> imagens, Set<Reservation> reservationSet, Category category, City city) {
        this.accoName = accoName;
        this.accoDescription = accoDescription;
        this.accoRoomNumber = accoRoomNumber;
        this.accoRoomGuests = accoRoomGuests;
        this.imagens = imagens;
        this.reservationSet = reservationSet;
        this.category = category;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccoName() {
        return accoName;
    }

    public void setAccoName(String accoName) {
        this.accoName = accoName;
    }

    public String getAccoDescription() {
        return accoDescription;
    }

    public void setAccoDescription(String accoDescription) {
        this.accoDescription = accoDescription;
    }

    public Integer getAccoRoomNumber() {
        return accoRoomNumber;
    }

    public void setAccoRoomNumber(Integer accoRoomNumber) {
        this.accoRoomNumber = accoRoomNumber;
    }

    public Integer getAccoRoomGuests() {
        return accoRoomGuests;
    }

    public void setAccoRoomGuests(Integer accoRoomGuests) {
        this.accoRoomGuests = accoRoomGuests;
    }

    public Set<Image> getImagens() {
        return imagens;
    }

    public void setImagens(Set<Image> imagens) {
        this.imagens = imagens;
    }

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
