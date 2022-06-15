package com.grupo7.airbnbclone.service;

import com.grupo7.airbnbclone.model.Reservation;
import com.grupo7.airbnbclone.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public Reservation saveReservation(Reservation reservation){return reservationRepository.save(reservation);}
    public List<Reservation> searchAllReservations(){return reservationRepository.findAll();}
    public Optional<Reservation> searchReservationById(Integer id){return reservationRepository.findById(id);}
    public Reservation updateReservation(Reservation reservation){return reservationRepository.save(reservation);}
    public void deleteReservation(Integer id){reservationRepository.deleteById(id);}

}
