package com.grupo7.airbnbclone.service;

import com.grupo7.airbnbclone.model.Accommodation;
import com.grupo7.airbnbclone.repositories.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    @Autowired
    AccommodationRepository accommodationRepository;

    public Accommodation saveAccommodation(Accommodation accommodation){return accommodationRepository.save(accommodation);}
    public List<Accommodation> searchAllAccommodations(){return accommodationRepository.findAll();}
    public Optional<Accommodation> searchAccommodationById(Integer id){return accommodationRepository.findById(id);}
    public Accommodation updateAccommodation(Accommodation accommodation){return accommodationRepository.save(accommodation);}
    public void deleteAccommodation(Integer id){accommodationRepository.deleteById(id);}

}
