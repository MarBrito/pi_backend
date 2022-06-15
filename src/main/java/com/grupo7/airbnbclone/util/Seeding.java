package com.grupo7.airbnbclone.util;

import com.grupo7.airbnbclone.model.*;
import com.grupo7.airbnbclone.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class Seeding implements ApplicationRunner {
    private ImageRepository imageRepository;
    private AccommodationRepository accommodationRepository;
    private SetOfImagesRepository setOfImagesRepository;
    private UserRepository userRepository;
    private ReservationRepository reservationRepository;
    private CategoryRepository categoryRepository;
    private CityRepository cityRepository;

    @Autowired
    public Seeding(ImageRepository imageRepository, AccommodationRepository accommodationRepository, SetOfImagesRepository setOfImagesRepository, UserRepository userRepository, ReservationRepository reservationRepository, CategoryRepository categoryRepository, CityRepository cityRepository) {
        this.imageRepository = imageRepository;
        this.accommodationRepository = accommodationRepository;
        this.setOfImagesRepository = setOfImagesRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.categoryRepository = categoryRepository;
        this.cityRepository = cityRepository;
    }


    public void run(ApplicationArguments args){

        City city1 = new City();
        city1.setCityName("São Paulo");
        city1.setCityState("São Paulo");
        city1.setCityCountry("Brasil");
        cityRepository.save(city1);

        Category category1 = new Category();
        category1.setCategoryName("Apartamento");
        category1.setCategoryDescription("Apartamento em cidades.");
        categoryRepository.save(category1);

        Accommodation accommodation1 = new Accommodation();
        accommodation1.setAccoName("Quarto em São Paulo");
        accommodation1.setAccoDescription("Apartamento maravilhoso em São Paulo com varanda belíssima");
        accommodation1.setAccoRoomGuests(4);
        accommodation1.setAccoRoomNumber(2);
        accommodation1.setCategory(category1);
        accommodation1.setCity(city1);

        Accommodation accommodation2 = new Accommodation();
        accommodation2.setAccoName("Quarto no Rio de Janeiro");
        accommodation2.setAccoDescription("Apartamento com vista para o Cristo Redentor e Praia de Ipanema");
        accommodation2.setAccoRoomGuests(5);
        accommodation2.setAccoRoomNumber(3);
        accommodation2.setCategory(category1);
        accommodation2.setCity(city1);

        accommodationRepository.save(accommodation1);
        accommodationRepository.save(accommodation2);

        Image imagem1 = new Image();
        SetOfImages objSetOfImages1 = new SetOfImages();
        Set<String> arraySetOfImages1 = new HashSet<>();
        String setimagem1 = "http://imagem1piscina.com";
        String setimagem2 = "http://imagem2piscina.com";
        arraySetOfImages1.add(setimagem1);
        arraySetOfImages1.add(setimagem2);

        objSetOfImages1.setLinksOfSetOfImages(arraySetOfImages1);
        objSetOfImages1.setNameOfSetOfImages("Piscina");

        imagem1.setHeaderImage("http://headerimage1.com");
        imagem1.setAccommodation(accommodation1);
        objSetOfImages1.setImage(imagem1);


        imageRepository.save(imagem1);
        setOfImagesRepository.save(objSetOfImages1);

        Set<Accommodation> setOfAccommodations = new HashSet<>();
        setOfAccommodations.add(accommodation1);
        setOfAccommodations.add(accommodation2);

        User user1 = new User();
        user1.setUserEmail("andersonemail@gmail.com");
        user1.setUserName("Anderson");
        user1.setUserSurname("Ribeiro");
        user1.setUserPassword("123456senha");

        userRepository.save(user1);

        Reservation reservation1 = new Reservation();
        reservation1.setReservationCheckIn(new Date());
        reservation1.setReservationCheckOut(new Date());
        reservation1.setUser(user1);
        reservation1.setAccommodationSet(setOfAccommodations);




        Set<Reservation> reservationSet = new HashSet<>();
        reservationSet.add(reservation1);
        accommodation1.setReservationSet(reservationSet);
        accommodation2.setReservationSet(reservationSet);

        reservationRepository.save(reservation1);

    }
}
