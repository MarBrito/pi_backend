package com.grupo7.airbnbclone.controller;

import com.grupo7.airbnbclone.model.Reservation;
import com.grupo7.airbnbclone.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation){
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> searchById(@PathVariable Integer id){
        return ResponseEntity.ok(reservationService.searchReservationById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> searchAll(){
        return ResponseEntity.ok(reservationService.searchAllReservations());
    }

    @PutMapping
    public ResponseEntity<Reservation> update(@RequestBody Reservation reservation){
        ResponseEntity<Reservation> response = null;
        if (reservation.getId() != null && reservationService.searchReservationById(reservation.getId()).isPresent()){
            response = ResponseEntity.ok(reservationService.updateReservation(reservation));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (reservationService.searchReservationById(id).isPresent()){
            reservationService.deleteReservation(id);
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
