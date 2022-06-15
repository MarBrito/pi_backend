package com.grupo7.airbnbclone.controller;

import com.grupo7.airbnbclone.model.Accommodation;
import com.grupo7.airbnbclone.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<Accommodation> save(@RequestBody Accommodation accommodation){
        return ResponseEntity.ok(accommodationService.saveAccommodation(accommodation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> searchById(@PathVariable Integer id){
        return ResponseEntity.ok(accommodationService.searchAccommodationById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Accommodation>> searchAll(){
        return ResponseEntity.ok(accommodationService.searchAllAccommodations());
    }

    @PutMapping
    public ResponseEntity<Accommodation> update(@RequestBody Accommodation accommodation){
        ResponseEntity<Accommodation> response = null;
        if (accommodation.getId() != null && accommodationService.searchAccommodationById(accommodation.getId()).isPresent()){
            response = ResponseEntity.ok(accommodationService.updateAccommodation(accommodation));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (accommodationService.searchAccommodationById(id).isPresent()){
            accommodationService.deleteAccommodation(id);
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
