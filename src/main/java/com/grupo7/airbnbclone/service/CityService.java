package com.grupo7.airbnbclone.service;

import com.grupo7.airbnbclone.model.City;
import com.grupo7.airbnbclone.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City saveCity (City city){return cityRepository.save(city);}
    public List<City> searchAllCities(){return cityRepository.findAll();}
    public Optional<City> searchCityById(Integer id){return cityRepository.findById(id);}
    public City updateCity (City city){return cityRepository.save(city);}
    public void deleteCity (Integer id){ cityRepository.deleteById(id);}


}
