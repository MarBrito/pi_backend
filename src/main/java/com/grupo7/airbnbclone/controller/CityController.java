package com.grupo7.airbnbclone.controller;

import com.grupo7.airbnbclone.model.City;
import com.grupo7.airbnbclone.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<City> save(@RequestBody City city){
        return ResponseEntity.ok(cityService.saveCity(city));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> searchById(@PathVariable Integer id){
        return ResponseEntity.ok(cityService.searchCityById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<City>> searchAll(){
        return ResponseEntity.ok(cityService.searchAllCities());
    }

    @PutMapping
    public ResponseEntity<City> update(@RequestBody City city){
        ResponseEntity<City> response = null;
        if (city.getId() != null && cityService.searchCityById(city.getId()).isPresent()){
            response = ResponseEntity.ok(cityService.updateCity(city));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (cityService.searchCityById(id).isPresent()){
            cityService.deleteCity(id);
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
