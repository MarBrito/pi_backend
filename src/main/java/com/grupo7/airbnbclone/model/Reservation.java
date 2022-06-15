package com.grupo7.airbnbclone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date reservationCheckIn;
    private Date reservationCheckOut;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    //@JsonManagedReference(value = "reservation-accommodation")
    private Set<Accommodation> accommodationSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value = "user-reservation")
    private User user;

    public Reservation() {
    }

    public Reservation(Integer id, Date reservationCheckIn, Date reservationCheckOut, Set<Accommodation> accommodationSet, User user) {
        this.id = id;
        this.reservationCheckIn = reservationCheckIn;
        this.reservationCheckOut = reservationCheckOut;
        this.accommodationSet = accommodationSet;
        this.user = user;
    }

    public Reservation(Date reservationCheckIn, Date reservationCheckOut, Set<Accommodation> accommodationSet, User user) {
        this.reservationCheckIn = reservationCheckIn;
        this.reservationCheckOut = reservationCheckOut;
        this.accommodationSet = accommodationSet;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReservationCheckIn() {
        return reservationCheckIn;
    }

    public void setReservationCheckIn(Date reservationCheckIn) {
        this.reservationCheckIn = reservationCheckIn;
    }

    public Date getReservationCheckOut() {
        return reservationCheckOut;
    }

    public void setReservationCheckOut(Date reservationCheckOut) {
        this.reservationCheckOut = reservationCheckOut;
    }

    public Set<Accommodation> getAccommodationSet() {
        return accommodationSet;
    }

    public void setAccommodationSet(Set<Accommodation> accommodationSet) {
        this.accommodationSet = accommodationSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
