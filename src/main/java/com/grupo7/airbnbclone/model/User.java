package com.grupo7.airbnbclone.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String userSurname;
    private String userPassword;
    private String userEmail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-reservation")
    private Set<Reservation> reservations = new HashSet<>();

    public User() {
    }

    public User(Integer id, String userName, String userSurname, String userPassword, String userEmail, Set<Reservation> reservations) {
        this.id = id;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.reservations = reservations;
    }

    public User(String userName, String userSurname, String userPassword, String userEmail, Set<Reservation> reservations) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
